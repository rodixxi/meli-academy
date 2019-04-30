package operations

import (
	"math"
)

func Sumar(a, b int) (suma int) {
	suma = a + b
	return
}

func Potencia(a float64, b float64) (potencia float64) {
	potencia = math.Pow(a, b)
	return
}