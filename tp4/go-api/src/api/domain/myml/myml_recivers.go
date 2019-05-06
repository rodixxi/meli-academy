package myml

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/user"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)


func (myml *Myml) GET() *apierrors.ApiError {
	userInstance  := &user.User{
		ID: myml.User.ID,
	}
	if err := userInstance.GET(); err != nil {
		return err
	}

	siteInstance  := &site.Site{
		ID: userInstance.SiteID,
	}
	if err := siteInstance.GET(); err != nil {
		return err
	}

	categoriesInstances := myml.Categories
	for _, categoryInSite := range siteInstance.Categories{
		categoryInstance  := category.Category{
			ID: categoryInSite.ID,
		}
		if err := categoryInstance.GET(); err != nil {
			return err
		}
		categoriesInstances = append(categoriesInstances, categoryInstance)
	}

	return nil
}

