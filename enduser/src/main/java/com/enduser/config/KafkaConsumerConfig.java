package com.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {

	private final static String LOCATION_TOPIC_NAME = "localtion-update-topic";
	private final static String GROUP_ID = "group-1";
	
	
	@KafkaListener(topics = LOCATION_TOPIC_NAME, groupId = GROUP_ID)
	public void updateLoacation(String value) {	
		
		System.out.println(value);
	}
	
}
