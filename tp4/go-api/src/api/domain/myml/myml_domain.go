package myml

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/user"
)

type Myml struct {
	User user.User
	Site site.Site
	Categories []category.Category
}
