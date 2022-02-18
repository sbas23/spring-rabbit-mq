package com.poc.rabbitmq.consumer;

import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.poc.rabbitmq.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class QueueConsumer {
	
	//@RabbitListener(queues = {"${queue.name}"})
    public void receiveMessage(@Payload Message message) {
    	
    	Map<String, Object> headers = message.getMessageProperties().getHeaders();
    	String spainId = headers.get("spanId").toString();
    	String str = new String(message.getBody(), java.nio.charset.StandardCharsets.UTF_8);
    	log.info("mensaje: {}", str);
        log.info("spainId: {}", spainId);
    }
	
	@RabbitListener(queues = {"${queue.name}"})
    public void receiveMessage2(@Payload User message) {
    	log.info("mensaje: {}", message);

    }
}
