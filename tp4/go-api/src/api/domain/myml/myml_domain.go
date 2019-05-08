package myml

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/user"
)

type Myml struct {
	User *user.User					`json:"user"`
	Site *site.Site					`json:"site"`
	Categories *[]category.Category	`json:"categories"`
}
