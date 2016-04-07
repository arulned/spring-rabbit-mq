package com.falcon.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.falcon.config.AMQPConfig;

@Component
public class MessageListener {

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue(value = "Queue1"), exchange = @Exchange(value = AMQPConfig.MY_FANOUT_EXCHANGE, type = ExchangeTypes.FANOUT)) })
	public void Queue1(String message) {
		System.out.println("Received " + message + " in Queue1 from fanout exchange");
	}

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue, exchange = @Exchange(value = AMQPConfig.MY_FANOUT_EXCHANGE, type = ExchangeTypes.FANOUT)) })
	public void Queue2(String message) {
		System.out.println("Received " + message + " in Queue2 from fanout exchange");
	}

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue(value = "nondeem.queue"), exchange = @Exchange(value = AMQPConfig.DIRECT_EXCHANGE, type = ExchangeTypes.DIRECT)) })
	public void Queue3(String message) {
		System.out.println("Received " + message + " in Queue3 from direct exchange");
	}

	@RabbitListener(bindings = {
			@QueueBinding(value = @Queue(value = "nondeem.queue"), exchange = @Exchange(value = AMQPConfig.DIRECT_EXCHANGE, type = ExchangeTypes.DIRECT)) })
	public void Queue4(String message) {
		System.out.println("Received " + message + " in Queue4 from direct exchange");
	}
}
