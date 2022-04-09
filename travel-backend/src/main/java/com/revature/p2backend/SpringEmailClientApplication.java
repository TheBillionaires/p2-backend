package com.revature.p2backend;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailClientApplication {
	
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
		String toEmail ="thebillionairesproject2@gmail.com";
		String body = "You have successfully registerd and your ticket is booked: April 11 at 11am";
		String subject = "Flight Management";
		service.sendSimpleEmail(toEmail,
				 body,
				subject);
	}
}