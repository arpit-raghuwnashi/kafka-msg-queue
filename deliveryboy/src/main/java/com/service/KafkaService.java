package com.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	private final static String LOCATION_TOPIC_NAME = "localtion-update-topic";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);

	public boolean updateLocation(String location) {
		this.kafkaTemplate.send(LOCATION_TOPIC_NAME, location);
		logger.debug("Message Produce");
		return true;
	}

}
