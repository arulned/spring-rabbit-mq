package com.falcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.falcon.config.AMQPConfig;

@SpringBootApplication
@Import(AMQPConfig.class)
public class SpringRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqApplication.class, args);
	}
}
