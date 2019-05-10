package main

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp5/go-api-elasticsearch/src/api/controller/item"
	"log"
)

func main() {
	//Star Elastic
	item.InitElastic()
	// Start HTTP server
	r := gin.Default()
	r.POST("/items", item.PostItems)
	r.GET("/items", item.GetItems)
	r.GET("/items/:id", item.GetItem)


	if err := r.Run(":8080"); err != nil {
		log.Fatal(err)
	}
}