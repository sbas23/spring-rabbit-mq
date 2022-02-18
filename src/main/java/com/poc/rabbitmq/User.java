package com.poc.rabbitmq;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;


@Data
@SuppressWarnings("serial")
public class User implements Serializable{
	private String name;
	private int age;
	private Map<String, Object> monitoring;
}
