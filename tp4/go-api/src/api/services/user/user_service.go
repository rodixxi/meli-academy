package user

import (
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/domain/user"
	"github.com/rodixxi/meli-academy/tp4/go-api/src/api/utils/apierrors"
)

func GetUserFromAPI(userId int64) (*user.User, *apierrors.ApiError) {
	userInstance := &user.User{
		ID: userId,
	}
	if err := userInstance.GET(); err != nil {
		return nil, err
	}
	return userInstance, nil
}
