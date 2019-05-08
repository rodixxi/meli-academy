package main

import (
	"fmt"
	"github.com/rodixxi/meli-academy/unit11/go-unitest/mio"
)

func main() {
	lista := [] int {6,3,1,5,7,0,2,9,8,4}
	err := mio.Acumular(lista)
	if err != nil {
		fmt.Println("Ocurrio un error no esperado")
	} else {
		fmt.Println(lista[9])
	}
}
