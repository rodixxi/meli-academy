package category

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/services/category"
	"net/http"

)

const (
	paramCategoryId = "categoryId"
)

func GetCategory(c *gin.Context) {

	categoryId := c.Param(paramCategoryId)
	user, apiErr := category.GetCategoryFromAPI(categoryId)
	if apiErr != nil {
		c.JSON(apiErr.Status, apiErr)
		return
	}
	c.JSON(http.StatusOK, user)
}
