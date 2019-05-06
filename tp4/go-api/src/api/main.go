package main

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/controller/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/controller/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/controller/user"
)

const (
	port = ":8080"
)

var	(
	router = gin.Default()
)

func main() {

	router.GET("/users/:userId", user.GetUser)
	router.GET("/sites/:siteId", site.GetSite)
	router.GET("/categories/:categoryId", category.GetCategory)

	router.Run(port)
}

