package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

type Site struct {
	Id string `json:"id"`
	Name string `json:"name"`
}

type Category struct {
	Id string `json:"id"`
	Name string `json:"name"`
}

func main() {

	fmt.Println("Iniciando aplicacion...")
	sites := GetSites()
	id := showMenuSites(sites)
	categories := GetCategories(id)
	id = showMenuCategories(categories)
	fmt.Println(id)

	fmt.Println("Terminando aplicacion...")
}

func GetSites() (sites []Site) {
	response, error := http.Get("https://api.mercadolibre.com/sites/")
	if error != nil {
		fmt.Printf("The HTTP request failed with error %s\n", error)
	} else {
		data, _ := ioutil.ReadAll(response.Body)
		error = json.Unmarshal(data, &sites)
	}
	return
}

func GetCategories(site string) (categories []Category) {
	response, error := http.Get("https://api.mercadolibre.com/sites/" + site + "/categories")
	if error != nil {
		fmt.Printf("The HTTP request failed with error %s\n", error)
	} else {
		data, _ := ioutil.ReadAll(response.Body)
		error = json.Unmarshal(data, &categories)
	}
	return
}

func showMenuSites(sites []Site) (id string){
	for index, element := range sites {
		fmt.Println(index, element.Name)
	}
	fmt.Println("Introduzca el numero del sitio: ")
	var i int
	_, error := fmt.Scanf("%d", &i)
	if error != nil {
		fmt.Printf("Condt read keyboard %s\n", error)
		i = 0
	}
	return sites[i].Id
}

func showMenuCategories(categories []Category) (id string){
	for index, element := range categories {
		fmt.Println(index, element.Name)
	}
	fmt.Println("Introduzca el numero del sitio: ")
	var i int
	_, error := fmt.Scanf("%d", &i)
	if error != nil {
		fmt.Printf("Condt read keyboard %s\n", error)
		i = 0
	}
	return categories[i].Id
}