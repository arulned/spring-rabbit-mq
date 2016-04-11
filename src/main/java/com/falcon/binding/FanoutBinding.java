package com.falcon.binding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.falcon.config.AMQPConfig;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@RabbitListener(bindings = @QueueBinding(value = @Queue, exchange = @Exchange(value = AMQPConfig.MY_FANOUT_EXCHANGE, type = ExchangeTypes.FANOUT)))
public @interface FanoutBinding {

}
