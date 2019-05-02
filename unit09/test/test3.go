package main

import (
	"fmt"
	"net/http"
	"net/url"
)

func main() {
	r, err := http.Get("https://api.libre.com/sites/MLA/categories")
	if err, ok := err.(*url.Error); ok {
		fmt.Println(err)
	} else {
		fmt.Println(r)
	}
}

type Error struct {
	Err string
	IsTimeout bool
	IsTemporary bool
}

func (e *Error) Error() string  {
	return e.Err
}
