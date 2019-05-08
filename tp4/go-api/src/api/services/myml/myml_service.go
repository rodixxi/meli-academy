package myml

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/myml"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/user"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetMymlFromAPI(userId int64) (*myml.Myml, *apierrors.ApiError) {
	userInstace := &user.User{
		ID: userId,
	}
	mymlInstance := &myml.Myml{
		User : userInstace,
	}
	if err := mymlInstance.GET(); err != nil {
		return nil, err
	}
	return mymlInstance, nil
}
