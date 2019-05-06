package myml

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/myml"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetUserFromAPI(userId int64) (*myml.User, *apierrors.ApiError) {
	user := &myml.User{
		ID: userId,
	}
	if err := user.GET(); err != nil {
		return nil, err
	}
	return user, nil
}
