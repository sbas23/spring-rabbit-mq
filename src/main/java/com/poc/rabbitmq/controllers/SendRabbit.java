package com.poc.rabbitmq.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.rabbitmq.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SendRabbit {
	
	@Value("${queue.exchance}")
	private String queueExchance;
	@Value("${queue.routing-key}")
	public String routingKey;

	private final AmqpTemplate queueSender;

	public SendRabbit(AmqpTemplate queueSender) {
		this.queueSender = queueSender;
	}

	@GetMapping("/plano")
	public String send() {
		log.info("Inicio procesamiento");
		UUID spanId = UUID.randomUUID();
		String mensagem = "mensaje con cabecera";
		
		MessageProperties messageProperties = new MessageProperties();
	    messageProperties.setHeader("spanId", spanId.toString());
	    Message message = new Message(mensagem.getBytes(), messageProperties);
	    
	    queueSender.convertAndSend(queueExchance, routingKey, message);
	    log.info("Fin procesamiento");
		return "ok. hecho";
	}
	
	@GetMapping("/object")
	public String sendObject() {
		log.info("Inicio procesamiento");
		UUID spanId = UUID.randomUUID();

		User user = new User();
		user.setName("Sebastian");
		user.setAge(31);
		Map<String, Object> data = new HashMap<>();
		data.put("spanId", spanId);
		user.setMonitoring(data);
	    
	    queueSender.convertAndSend(queueExchance, routingKey, user);
	    log.info("Fin procesamiento");
		return "ok. hecho";
	}
}
