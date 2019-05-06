package site

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/services/site"
	"net/http"
)

const (
	paramSiteId = "siteId"
)

func GetSite(c *gin.Context) {

	siteId := c.Param(paramSiteId)
	user, apiErr := site.GetSiteFromAPI(siteId)
	if apiErr != nil {
		c.JSON(apiErr.Status, apiErr)
		return
	}
	c.JSON(http.StatusOK, user)
}
