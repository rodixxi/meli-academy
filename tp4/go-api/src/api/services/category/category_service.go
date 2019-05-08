package category

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetCategoryFromAPI(categoryId string) (*category.Category, *apierrors.ApiError) {
	categoriesInstance := &category.Category{
		ID: categoryId,
	}
	if err := categoriesInstance.GET(); err != nil {
		return nil, err
	}
	return categoriesInstance, nil
}
/*
func GetCategoriesFromAPICall(categoryId string, cResponse chan *myml.Myml, cError chan *apierrors.ApiError) {
	categoriesInstance := &category.Category{
		ID: categoryId,
	}
	if err := categoriesInstance.GET(); err != nil {
		cError <- err
	}
	cResponse <- &myml.Myml{
		Categories: categoriesInstance,
	}
}
*/