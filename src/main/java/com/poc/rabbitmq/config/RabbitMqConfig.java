package com.poc.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
	
	@Value("${queue.exchance}")
	private String queueExchance;
	@Value("${queue.name}")
	private String queue;
	@Value("${queue.routing-key}")
	public String routingKey;
	private static final boolean IS_DURABLE_QUEUE = true;


	@Bean
	Queue queue() {
		return new Queue(queue, IS_DURABLE_QUEUE);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(queueExchance);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

}
