package com.falcon.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.config.AMQPConfig;

@RestController
public class MyController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "/api/v1/create")
	public String createStream(@RequestParam("type") String type) {
		if ("fanout".equalsIgnoreCase(type)) {
			rabbitTemplate.convertAndSend(AMQPConfig.MY_FANOUT_EXCHANGE, null, "a Message");
		} else {
			rabbitTemplate.convertAndSend(AMQPConfig.DIRECT_EXCHANGE, null, "a Message");
		}
		return String.valueOf(System.currentTimeMillis());
	}
}
