package main

import (
	"fmt"
	"net/http"
	"testing"
)

const (
	mymlAPiUrl = "http://localhost:8080/myml/1"
)

func BenchmarkAcumular1(b *testing.B) {
	lista := generarLista(1)
	for n := 0; n < b.N; n++ {
		for i := 0 ; i < len(lista) ; i ++ {
			status, err := getCall(mymlAPiUrl)
			if err != nil {
				b.Error(fmt.Sprintf("No se esperaba un error: %s", err))
			}
			if status != 200 {
				b.Error(fmt.Sprintf("No se este estatus: %d", status))
			}
		}
	}
}

func BenchmarkAcumular10(b *testing.B) {
	lista := generarLista(10)
	for n := 0; n < b.N; n++ {
		for i := 0 ; i < len(lista) ; i ++ {
			status, err := getCall(mymlAPiUrl)
			if err != nil {
				b.Error(fmt.Sprintf("No se esperaba un error: %s", err))
			}
			if status != 200 {
				b.Error(fmt.Sprintf("No se este estatus: %d", status))
			}
		}
	}
}

func BenchmarkAcumular100(b *testing.B) {
	lista := generarLista(100)
	for n := 0; n < b.N; n++ {
		for i := 0 ; i < len(lista) ; i ++ {
			status, err := getCall(mymlAPiUrl)
			if err != nil {
				b.Error(fmt.Sprintf("No se esperaba un error: %s", err))
			}
			if status != 200 {
				b.Error(fmt.Sprintf("No se este estatus: %d", status))
			}
		}
	}
}

func BenchmarkAcumular1000(b *testing.B) {
	lista := generarLista(1000)
	for n := 0; n < b.N; n++ {
		for i := 0 ; i < len(lista) ; i ++ {
			status, err := getCall(mymlAPiUrl)
			if err != nil {
				b.Error(fmt.Sprintf("No se esperaba un error: %s", err))
			}
			if status != 200 {
				b.Error(fmt.Sprintf("No se este estatus: %d", status))
			}
		}
	}
}

func BenchmarkAcumular10000(b *testing.B) {
	lista := generarLista(10000)
	for n := 0; n < b.N; n++ {
		for i := 0 ; i < len(lista) ; i ++ {
			status, err := getCall(mymlAPiUrl)
			if err != nil {
				b.Error(fmt.Sprintf("No se esperaba un error: %s", err))
			}
			if status != 200 {
				b.Error(fmt.Sprintf("No se este estatus: %d", status))
			}
		}
	}
}


func getCall(url string) (int, error){
	r, err := http.Get(url)
	if err != nil {
		return 0, err
	}
	return r.StatusCode, nil
}

func generarLista(n int) []int {
	var lista = make([]int, n)
	for i := 0; i < n; i++ {
		lista[i] = i
	}
	return lista
}