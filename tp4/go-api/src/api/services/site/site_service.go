package site

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/site"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetSiteFromAPI(siteId string) (*site.Site, *apierrors.ApiError) {
	site := &site.Site{
		ID: siteId,
	}
	if err := site.GET(); err != nil {
		return nil, err
	}
	return site, nil
}
