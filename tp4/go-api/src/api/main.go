package main

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/controller/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/controller/myml"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/controller/site"
)

const (
	port = ":8080"
)

var	(
	router = gin.Default()
)

func main() {

	router.GET("/users/:userId", myml.GetUser)
	router.GET("/sites/:siteId", site.GetSite)
	router.GET("/categories/:categoryId", category.GetCategory)

	router.Run(port)
}

