package com.progressivecoder.demo.subscriberapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(MessageChannel.class)
public class SubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriberApplication.class, args);
	}

	@StreamListener(MessageChannel.MESSAGES)
	public void handleMessage(String message) throws Exception{

		System.out.println(message);

		if(message.contains("leave"))
			throw new Exception("Someone wants a vacation! Reject the leave application");

		System.out.println("Subscriber Received Message is: " + message);
	}

}
