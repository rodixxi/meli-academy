package main

import (
	"fmt"
)

func main() {
	defer funcion1()
	for i:=0 ; i<100 ; i++ {
		fmt.Print(i)
	}
	fmt.Print("\n")
	funcion2()
}

func funcion1() {
	fmt.Println("Imprime funcion 1")
}

func funcion2() {
	fmt.Println("Imprime funcion 2")
}
