package com.lxf.testdns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
	String hostname = new String("bing.com");
	if (args.length > 0) {
		hostname = args[0];
	}

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread(hostname);
            executor.execute(worker);
          }
        executor.shutdown();
//        while (!executor.isTerminated()) {
 //       }
//        System.out.println("Finished all threads");
    }
}

