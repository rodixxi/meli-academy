package myml

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/unit10/myml/src/api/services/myml"
	"net/http"
	"strconv"
	"github.com/rodixxi/meli-academy/unit10/myml/src/api/utils/apierrors"

)

const (
	paramUserId = "userId"
)

func GetUser(c *gin.Context) {

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
	user, apiErr := myml.GetUserFromAPI(id)
	if apiErr != nil {
		c.JSON(apiErr.Status, apiErr)
		return
	}
	c.JSON(http.StatusOK, user)
}
