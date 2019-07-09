package com.progressivecoder.anothersubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(MessageChannel.class)
public class AnotherSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotherSubscriberApplication.class, args);
	}

	@StreamListener(MessageChannel.MESSAGES)
	public void handleMessage(String message) throws Exception {

		System.out.println(message);

		if(message.contains("leave"))
			throw new Exception("Some wants a vacation! Reject the leave application");

		System.out.println("Another Subscriber Received Message is: " + message);
	}

	public static class Message{
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return "Message{" +
					"message='" + message + '\'' +
					'}';
		}
	}

}
