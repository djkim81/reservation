package com.pilot.reservation;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.pilot.reservation.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler {

	@StreamListener(KafkaProcessor.INPUT)
	public void onStringEventListener(@Payload String eventString) {
		
	}
}
