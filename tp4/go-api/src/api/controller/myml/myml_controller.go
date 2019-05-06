package myml

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/services/myml"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
	"net/http"
	"strconv"
)

const (
	paramUserId = "userId"
)

func GetMyml(c *gin.Context) {

	userId := c.Param(paramUserId)
	id, err := strconv.ParseInt(userId, 10, 64)
	if err != nil {
		apiErr := &apierrors.ApiError{
			Message: err.Error(),
			Status: http.StatusBadRequest,
		}
		c.JSON(apiErr.Status, apiErr)
		return
	}
	mymlInstance, apiErr := myml.GetMymlFromAPI(id)
	if apiErr != nil {
		c.JSON(apiErr.Status, apiErr)
		return
	}
	c.JSON(http.StatusOK, mymlInstance)
}
