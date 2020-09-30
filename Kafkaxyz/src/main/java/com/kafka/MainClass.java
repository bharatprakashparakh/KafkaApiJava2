package com.kafka;

/*
 Perform the following steps on Command Line before executing the below code:-
 a.Start Zookeeper service.(port 2181)
 b.Start Kafka Server.(port 9092)
 c.Create Topic
  
 */

public class MainClass {

	public static void main(String[] args)
	{
		ProducerApi prod=new ProducerApi();
		ConsumerApi con=new ConsumerApi();
		prod.producer();
		con.consumer();
		
		System.out.println("Task Completed");
	}
}
