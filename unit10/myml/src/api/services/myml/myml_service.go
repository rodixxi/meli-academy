package myml

import (
	"github.com/rodixxi/meli-academy/unit10/myml/src/api/domain/myml"
	"github.com/rodixxi/meli-academy/unit10/myml/src/api/utils/apierrors"
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
