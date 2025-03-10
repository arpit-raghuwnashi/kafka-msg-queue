package com.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.KafkaService;

@RestController
@RequestMapping("/current-location")
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;
	Logger log = LoggerFactory.getLogger(KafkaController.class);

	// read from terminal
	// $ bin/kafka-console-consumer.sh --topic localtion-update-topic
	// --from-beginning --bootstrap-server localhost:9092

	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {
		log.info("Received request to update location");
		for (int i = 1; i <= 2000000; i++) {
			String location = "( " + Math.round(Math.random() * 1000000) + " , " + Math.round(Math.random() * 1000000) + " )";
			this.kafkaService.updateLocation(location);

		}
		return new ResponseEntity<>(Map.of("message", "Localtion Updated"), HttpStatus.OK);
	}

}
