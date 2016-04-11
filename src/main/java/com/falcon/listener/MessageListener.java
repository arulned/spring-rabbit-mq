package com.falcon.listener;

import org.springframework.stereotype.Component;

import com.falcon.binding.DirectBinding;
import com.falcon.binding.FanoutBinding;

@Component
public class MessageListener {

	@FanoutBinding
	public void Queue1(String message) {
		System.out.println("Received " + message + " in Queue1 from fanout exchange");
	}

	@FanoutBinding
	public void Queue2(String message) {
		System.out.println("Received " + message + " in Queue2 from fanout exchange");
	}

	@DirectBinding
	public void Queue3(String message) {
		System.out.println("Received " + message + " in Queue3 from direct exchange");
	}

	@DirectBinding
	public void Queue4(String message) {
		System.out.println("Received " + message + " in Queue4 from direct exchange");
	}
}
