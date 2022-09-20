package main

import (
	"fmt"
	"net"
	"os"
	"sync"
	"time"
)

func main() {
	if len(os.Args) == 1 {
		fmt.Println("Please provide a hostname in command arg, e.g. 'bing.com'")
		os.Exit(1)
	}
	hostname := os.Args[1]
	var wg sync.WaitGroup

	for i := 1; i <= 10; i++ {
		wg.Add(1)
		go func(n int) {
			for {
				defer wg.Done()
				start := time.Now()
				addrs, err := net.LookupHost(hostname)
				d := time.Since(start)
				if err != nil {
					fmt.Printf("#%02d: Fail to resolve IP:%s. Time taken %v\n", n, err, d)
				} else {
					fmt.Printf("#%02d: IP addrs of '%s': %v. Time taken %v\n", n, hostname, addrs, d)
				}
				time.Sleep(time.Second)
			}
		}(i)
	}
	wg.Wait()
}
