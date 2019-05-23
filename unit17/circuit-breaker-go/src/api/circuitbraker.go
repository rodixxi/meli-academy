package circuitbraker

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"time"

	"github.com/eapache/go-resiliency/retrier"
	"github.com/afex/hystrix-go/hystrix"
)


var Client http.Client

const (
	retries = 3
)

// PerformHTTPRequestCircuitBreaker performs the supplied http.Request within a circuit breaker.
func PerformHTTPRequestCircuitBreaker(breakerName string, req *http.Request) ([]byte, error) {
	output := make(chan []byte, 1)
	errors := hystrix.Go(breakerName, func() error {
		err := callWithRetries(req, output)
		return err // For hystrix, forward the err from the retrier. It's nil if OK.
	}, func(err error) error {
		log.Println("In fallback function for breaker %v, error: %v", breakerName, err.Error())
		return err
	})

	select {
	case out := <-output:
		log.Println("Call in breaker %v successful", breakerName)
		return out, nil

	case err := <-errors:
		log.Println("Got error on channel in breaker %v. Msg: %v", breakerName, err.Error())
		return nil, err
	}
}

// CallUsingCircuitBreaker performs a HTTP call inside a circuit breaker.
func CallUsingCircuitBreaker(breakerName string, url string, method string) ([]byte, error) {
	output := make(chan []byte, 1)
	errors := hystrix.Go(breakerName, func() error {

		req, _ := http.NewRequest(method, url, nil)
		err := callWithRetries(req, output)

		return err // For hystrix, forward the err from the retrier. It's nil if OK.
	}, func(err error) error {
		log.Printf("In fallback function for breaker %v, error: %v", breakerName, err.Error())
		circuit, _, _ := hystrix.GetCircuit(breakerName)
		log.Printf("Circuit state is: %v", circuit.IsOpen())
		return err
	})

	select {
	case out := <-output:
		log.Printf("Call in breaker %v successful", breakerName)
		return out, nil

	case err := <-errors:
		log.Printf("Got error on channel in breaker %v. Msg: %v", breakerName, err.Error())
		return nil, err
	}
}



func callWithRetries(req *http.Request, output chan []byte) error {
	// Create a retrier with constant backoff, RETRIES number of attempts (3) with a 100ms sleep between retries.
	r := retrier.New(retrier.ConstantBackoff(retries, 100 * time.Millisecond), nil)
	// This counter is just for getting some logging for showcasing, remove in production code.
	attempt := 0
	// Retrier works similar to hystrix, we pass the actual work (doing the HTTP request) in a func.
	err := r.Run(func() error {
		attempt++
		// Do HTTP request and handle response. If successful, pass resp.Body over output channel,
		// otherwise, do a bit of error logging and return the err.
		resp, err := Client.Do(req)
		if err == nil && resp.StatusCode < 299 {
			responseBody, err := ioutil.ReadAll(resp.Body)
			if err == nil {
				output <- responseBody
				return nil
			}
			return err
		} else if err == nil {
			err = fmt.Errorf("Status was %v", resp.StatusCode)
		}
		log.Printf("Retrier failed, attempt %v", attempt)
		return err
	})
	return err
}

