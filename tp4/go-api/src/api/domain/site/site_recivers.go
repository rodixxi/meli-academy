package site

import (
	"encoding/json"
	"fmt"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
	"io/ioutil"
	"net/http"
)

const (
	userAPIUrl = "https://api.mercadolibre.com/sites/"
)

func (site *Site) GET() *apierrors.ApiError {
	url := fmt.Sprintf("%s%s", userAPIUrl, site.ID)
	r, err := http.Get(url)
	if err != nil {
		return &apierrors.ApiError{
			Message: err.Error(),
			Status: http.StatusInternalServerError,
		}
	}
	data, err := ioutil.ReadAll(r.Body)
	if err != nil {
		return &apierrors.ApiError{
			Message: err.Error(),
			Status: http.StatusInternalServerError,
		}
	}
	if err := json.Unmarshal(data, &site); err != nil {
		return &apierrors.ApiError{
			Message: err.Error(),
			Status: http.StatusInternalServerError,
		}
	}
	return nil
}
