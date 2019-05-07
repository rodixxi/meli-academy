package mio

import (
	"errors"
)

func Acumular(lista []int) error {
	if lista == nil{
		return errors.New("la lista esta vacia")
	}
	for i := 1; i < (len(lista)); i++ {
		lista[i] = lista[i - 1] + lista[i]

	}
	return nil
}

