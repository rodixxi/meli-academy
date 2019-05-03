package main

import (
	"github.com/gin-gonic/gin"
	"github.com/rodixxi/meli-academy/unit10/myml/src/api/controller/myml"
)

const (
	port = ":8080"
)

var	(
	router = gin.Default()
)

func main() {

	router.GET("/users/:userId", myml.GetUser)

	router.Run(port)
}
