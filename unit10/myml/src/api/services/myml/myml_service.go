package myml

import (
	"../../domain/myml"
	"../../utils/apierrors"
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
