package com.progressivecoder.demo.publisherapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

}

@RestController
@EnableBinding(Source.class)
class MessagePublisher{

	@Autowired
	private Source source;

	@GetMapping(value = "/api/publish")
	public void sendMessage(){
		Message message = new Message("Hello World from Publisher");

		source.output().send(MessageBuilder.withPayload(message).build());

	}
}

class Message{
	String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
