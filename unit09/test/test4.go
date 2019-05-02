package main

import (
	"./errors"
	"fmt"
	"math"
)

func main() {
	sqrt, err := squareRoot(-1)
	if err, ok := err.(*errors.MiError); ok {
		fmt.Println(err.Error())
	} else {
		fmt.Println(sqrt)
	}
}

func squareRoot(a float64) (float64, error)  {
	if a < 0 {
		return 0, errors.New("El numero debe ser positivo")
	}
	return math.Sqrt(a), nil
}
