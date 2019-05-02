package main

import (
	"./domain"
	"fmt"
)

func main() {
	sitio1 := domain.Site{
		Id: "MLA",
		Name: "Argentina",
	}
	sitio2 := domain.Site{
		Name: "Brasil",
	}
	fmt.Println(sitio1)
	fmt.Println(sitio2)

	categotia1 := domain.Category{
		Id: "MLA5432",
		Name: "Accesorios",
		Site: sitio1,
	}

	categotia2 := domain.Category{
		Id: "MLA5432",
		Name: "Accesorios",
		Site: sitio1,
	}

	categotia3 := domain.Category{
		Id: "MLB1111",
		Name: "Accesorios",
		Site: domain.Site{
		Id: "MLB",
		Name: "Brasil",
		},
	}

	categotia4 := domain.Category{
		Site: sitio2,
	}

	fmt.Println(categotia1)
	fmt.Println(categotia2.Site.Name)
	fmt.Println(categotia3)
	fmt.Println(categotia4)

	if categotia1 == categotia2 {
		fmt.Println("Las categorias son iguales")
	} else {
		fmt.Println("Las categorias NO son iguales")
	}

	if categotia1 == categotia3 {
		fmt.Println("Las categorias son iguales")
	} else {
		fmt.Println("Las categorias NO son iguales")
	}

	fmt.Println(categotia1.GetIdsConcat())
	fmt.Println(categotia1.Name)
	categotia1.ChangeName("Otro")
	fmt.Println(categotia1.Name)
	categotia1.ChangeNameP("Otro")
	fmt.Println(categotia1.Name)

}