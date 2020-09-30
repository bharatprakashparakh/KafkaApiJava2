/*
 * This code creates a consumer,subscribes to it and consumes the data from the specified topic.
 */


package com.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerApi {

	void consumer()
	{
		
		String topicName = "demotopic"; 
        String groupName = "testDemoGroup";

        //Declare Properties object and feed details of Kafka server and serializer for converting data back to string.
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", groupName);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //create consumer object and pass obove properties to it.
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        
        //consumer will subscribe to above topic
        consumer.subscribe(Arrays.asList(topicName));

       
        //Now, read data from topic until it becomes empty
		try
		{
			
				 while (true){
			      ConsumerRecords<String, String> records = consumer.poll(100);
			      for (ConsumerRecord<String, String> record : records){
			              System.out.println("Supplier id= " + String.valueOf(record.value()));
			              //+ " Supplier  Name = " + record.value().getName() + " Supplier Start Date = " + record.value().getStartDate().toString());
			      consumer.close();
			      }
		      }
       }
		catch(Exception e)
		{
				System.out.println("consumer work completed");
		}
		
 }
		
}

