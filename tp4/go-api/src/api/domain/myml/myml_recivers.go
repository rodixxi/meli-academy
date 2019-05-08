package myml

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/user"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
	"sync"
)


func (myml *Myml) GET() *apierrors.ApiError {
	userInstance  := &user.User{
		ID: myml.User.ID,
	}
	if err := userInstance.GET(); err != nil {
		return err
	}

	myml.User = userInstance

	cResponses := make(chan *Myml)
	cErrors := make(chan *apierrors.ApiError)

	var wg sync.WaitGroup
	goRoutinesCount := 1

	go func() {
		for i := 0; i < goRoutinesCount; i++ {
			currentOrder := <-cResponses
			wg.Done()
			if currentOrder.Site != nil {
				myml.Site = currentOrder.Site
				continue
			}
/*
			if currentOrder.Categories != nil {
				myml.Categories = currentOrder.Categories
				continue
			}
*/
		}
	}()

	wg.Add(goRoutinesCount)
	go GetSiteFromAPICall(myml.User.SiteID, cResponses, cErrors)
	//go category.GetCategoriesFromAPICall(myml.User.SiteID, cResponses, cErrors)
	wg.Wait()

	return nil
}
/*

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
*/

func GetSiteFromAPICall(siteId string, cResponse chan *Myml, cError chan *apierrors.ApiError) {
	siteInstance := &site.Site{
		ID: siteId,
	}
	if err := siteInstance.GET(); err != nil {
		cError <- err
	}

	cResponse <- &Myml{
		Site: siteInstance,
	}
}