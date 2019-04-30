package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	fmt.Println("Iniciando aplicacion...")
	response, error := http.Get("https://httpbin.org/ip")
	if error != nil {
		fmt.Println("Ocurrio un errror %s/n", error)
	} else {
		data, _ := ioutil.ReadAll(response.Body)
		fmt.Println(string(data))
	}
	jsonData := map[string]string {
		"nombre": "pipo",
		"apellido": "pepo"}
	jsonValue, _ := json.Marshal(jsonData)
	response, error = http.Post("https://httpbin.org/post", "application/json", bytes.NewBuffer(jsonValue))
	if error != nil {
		fmt.Printf("The HTTP request failed with error %s\n", error)
	} else {
		data, _ := ioutil.ReadAll(response.Body)
		fmt.Println(string(data))
	}

	fmt.Println("Terminando aplicacion...")
}
