package site

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetSiteFromAPI(siteId string) (*site.Site, *apierrors.ApiError) {
	siteInstance := &site.Site{
		ID: siteId,
	}
	if err := siteInstance.GET(); err != nil {
		return nil, err
	}
	return siteInstance, nil
}