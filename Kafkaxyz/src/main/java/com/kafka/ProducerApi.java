/*
 * This code creates a producer and publish data to the topic.
 */

package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerApi {

	void producer()
	{
		//Declare topic,key and value
		String topicName="demotopic";
		String key="key1";
		String value="samplevalue";
		
		//Declare Properties object and assign Kafka server location and key,value serializer to convert the string value into bytes. 
		Properties properties=new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
        //create Producer object using above properties.Create record to give details of topic,key and value to be published. 
		Producer<String,String> producer=new KafkaProducer<>(properties);
		ProducerRecord<String,String> record=new ProducerRecord<>(topicName,key,value);
		//Publish the record into topic
		producer.send(record);
		
		producer.close();
		System.out.println("Completed");
		
	}
}
