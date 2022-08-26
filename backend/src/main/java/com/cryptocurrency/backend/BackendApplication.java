package com.cryptocurrency.backend;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BackendApplication {
 private static int counter=0;
	public static void main(String[] args) {
		// SpringApplication.run(BackendApplication.class, args);
		 
		 
		 TimerTask timerTask = new TimerTask() {
	           @Override
	           public void run() {
	        	   counter++;
	               System.out.println("task  run:"+ new Date()+" counter: "+counter);
	           }

	       };

	       Timer timer = new Timer();

	       //Schedule the specified task to start repeated, fixed delays at a specified time.This is executed every 3 seconds
	       timer.schedule(timerTask,10,3000);
	       
	   }
		 		
	

}
