package category

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/category"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetCategoryFromAPI(categoryId string) (*category.Category, *apierrors.ApiError) {
	category := &category.Category{
		ID: categoryId,
	}
	if err := category.GET(); err != nil {
		return nil, err
	}
	return category, nil
}
