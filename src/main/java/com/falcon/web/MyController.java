package com.falcon.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.config.AMQPConfig;

@RestController
public class MyController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "/api/v1/fanout")
	public String fanout() {
		rabbitTemplate.convertAndSend(AMQPConfig.MY_FANOUT_EXCHANGE, null, String.valueOf(System.currentTimeMillis()));
		return String.valueOf(System.currentTimeMillis());
	}

	@RequestMapping(value = "/api/v1/direct")
	public String direct() {
		rabbitTemplate.convertAndSend(AMQPConfig.DIRECT_EXCHANGE, null, String.valueOf(System.currentTimeMillis()));
		return String.valueOf(System.currentTimeMillis());
	}
}
