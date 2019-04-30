package main

import (
	"./operations"
	"fmt"
)

func main() {
	fmt.Println(operations.Sumar(10, 20))
	fmt.Println(operations.Potencia(20.0, 3.0))
}

func operar(a,b int) (suma int, producto int) {
	suma = a + b
	producto = a * b
	return
}