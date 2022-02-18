//package com.poc.rabbitmq.publisher;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import com.poc.rabbitmq.User;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class QueueSender {
//
//	@Autowired
//	RabbitTemplate rabbitTemplate;
//	
//	@Autowired
//    private Queue queue;
//
//	public void send(String message) {
//		log.info("Enviando mensaje");
//		rabbitTemplate.convertAndSend(this.queue.getName(), message);
//	}
//
//
//}
