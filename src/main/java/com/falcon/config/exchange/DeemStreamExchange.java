package com.falcon.config.exchange;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;

import com.falcon.config.AMQPConfig;

@Retention(RetentionPolicy.RUNTIME)
public @interface DeemStreamExchange {
	Exchange exchange() default @Exchange(value = AMQPConfig.MY_FANOUT_EXCHANGE, type = ExchangeTypes.FANOUT);
}
