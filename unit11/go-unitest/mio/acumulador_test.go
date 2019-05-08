package mio

import (
	"fmt"
	"testing"
)

func TestAcumulado(t *testing.T) {
	lista := [] int {6,3,1,5,7,0,2,9,8,4}
	err := Acumular(lista)
	if err != nil {
		t.Error("No se esperaba un error")
	}
	if lista[9] != 45 {
		t.Error("No se acumulo segun lo esperado")
	}
}

func TestAcumuladoListaNula(t *testing.T) {
	err := Acumular(nil)
	if err == nil {
		t.Error("Se esperaba un error")
	}
	errorEsperado := "la lista esta vacia"
	if err.Error() != errorEsperado {
		t.Error(fmt.Sprintf("Mensake de error esperado: %s, mensaje de error recibido: %s", errorEsperado, err.Error()))
	}
}

func BenchmarkAcumular10(b *testing.B) {
	lista := generarLista(10)
	for n := 0; n < b.N; n++ {
		Acumular(lista)
	}
}

func BenchmarkAcumular100(b *testing.B) {
	lista := generarLista(100)
	for n := 0; n < b.N; n++ {
		Acumular(lista)
	}
}

func BenchmarkAcumular1000(b *testing.B) {
	lista := generarLista(1000)
	for n := 0; n < b.N; n++ {
		Acumular(lista)
	}
}

func BenchmarkAcumular10000(b *testing.B) {
	lista := generarLista(10000)
	for n := 0; n < b.N; n++ {
		Acumular(lista)
	}
}

func generarLista(n int) []int {
	var lista = make([]int, n)
	for i := 0; i < n; i++ {
		lista[i] = i
	}
	return lista
}


