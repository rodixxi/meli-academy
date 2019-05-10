package item

import (
	"encoding/json"
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp5/go-api-elasticsearch/src/api/domian/item"
	"github.com/teris-io/shortid"
	"gopkg.in/olivere/elastic.v6"
	"log"
	"net/http"
	"strconv"
	"time"
)

const (
	elasticIndexName = "items_index"
	elasticTypeName  = "items"
	elasticURL = "http://localhost:9200"
	paramGetUser = "id"
)

var (
	elasticClient *elastic.Client
)

type SearchResponse struct {
	Time      string             `json:"time"`
	Hits      string             `json:"hits"`
	Items 	  []item.Item        `json:"items"`
}

func InitElastic() {
	var err error
	// Create Elastic client and wait for Elasticsearch to be ready
	for {
		elasticClient, err = elastic.NewClient(
			elastic.SetURL(elasticURL),
			elastic.SetSniff(false),
		)
		if err != nil {
			log.Println(err)
			// Retry every 3 seconds
			time.Sleep(3 * time.Second)
		} else {
			break
		}
	}

}

func PostItems(c *gin.Context) {
	// Parse request
	var items []item.Item
	if err := c.BindJSON(&items); err != nil {
		errorResponse(c, http.StatusBadRequest, "Malformed request body")
		return
	}
	// Insert documents in bulk
	bulk := elasticClient.
		Bulk().
		Index(elasticIndexName).
		Type(elasticTypeName)
	for _, i := range items {
		itemInstance := item.Item{
			ID:        shortid.MustGenerate(),
			Title:     i.Title,
		}
		bulk.Add(elastic.NewBulkIndexRequest().Id(itemInstance.ID).Doc(itemInstance))
	}
	if _, err := bulk.Do(c.Request.Context()); err != nil {
		log.Println(err)
		errorResponse(c, http.StatusInternalServerError, "Failed to create documents")
		return
	}
	c.Status(http.StatusOK)
}

func GetItems(c *gin.Context) {
	//id := c.Param(paramGetUser)
	skip := 0
	take := 10
	if i, err := strconv.Atoi(c.Query("skip")); err == nil {
		skip = i
	}
	if i, err := strconv.Atoi(c.Query("take")); err == nil {
		take = i
	}
	// Perform search

	esQuery := elastic.NewMatchAllQuery()
	result, err := elasticClient.Search().
		Index(elasticIndexName).
		Query(esQuery).
		From(skip).Size(take).
		Pretty(true).
		Do(c.Request.Context())
	if err != nil {
		log.Println(err)
		errorResponse(c, http.StatusInternalServerError, "Something went wrong")
		return
	}
	// Transform search results before returning them
	items := make([]item.Item, 0)
	for _, hit := range result.Hits.Hits {
		var itemInstance item.Item
		err = json.Unmarshal(*hit.Source, &itemInstance)
		if err != nil {
			log.Println(err)
			errorResponse(c, http.StatusInternalServerError, "Something went wrong when parsing")
			return
		}
		items = append(items, itemInstance)
	}
	c.JSON(http.StatusOK, items)
}

func GetItem(c *gin.Context) {
	id := c.Param(paramGetUser)
	// Perform search

	esQuery := elastic.NewTermQuery("id", id)
	result, err := elasticClient.Search(elasticIndexName).
		Index(elasticIndexName).
		Query(esQuery).
		Pretty(true).
		Do(c.Request.Context())
	if err != nil {
		log.Println(err)
		errorResponse(c, http.StatusInternalServerError, "Something went wrong")
		return
	}
	// Transform search results before returning them
	items := make([]item.Item, 0)
	for _, hit := range result.Hits.Hits {
		var itemInstance item.Item
		err = json.Unmarshal(*hit.Source, &itemInstance)
		if err != nil {
			log.Println(err)
			errorResponse(c, http.StatusInternalServerError, "Something went wrong when parsing")
			return
		}
		items = append(items, itemInstance)
	}
	c.JSON(http.StatusOK, items)
}

func errorResponse(c *gin.Context, code int, err string) {
	c.JSON(code, gin.H{
		"error": err,
	})
}