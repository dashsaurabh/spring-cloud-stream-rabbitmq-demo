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
		String message = "I want leave";

		source.output().send(MessageBuilder.withPayload(message).build());

	}
}
