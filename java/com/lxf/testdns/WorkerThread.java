package com.lxf.testdns;

import java.time.Instant;
import java.time.Duration;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WorkerThread implements Runnable {
  
    private String hostname;
    
    public WorkerThread(String s){
        this.hostname = s;
    }

    @Override
    public void run() {
	String t = Thread.currentThread().getName();
        processCommand(t);
    }

    private void processCommand(String t) {
      while (true) {
	String output;
	Instant start = Instant.now();
        try {
    		InetAddress address = InetAddress.getByName(this.hostname);
		output = address.toString();
	} catch(UnknownHostException e){
    		output = e.toString();
        } 
	Instant finish = Instant.now();
	long timeElapsed = Duration.between(start, finish).toMillis();
	System.out.println(t + "=> " + output + ". Time taken: " + timeElapsed + "ms");

	try {
        	Thread.sleep(2000); //sleep 2s
	}catch (InterruptedException e) {
    		System.err.println(e);
        }
      }
    }
}
