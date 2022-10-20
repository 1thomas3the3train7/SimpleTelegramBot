package com.example.telegrambot;

import com.example.telegrambot.Service.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegrambotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);
	}
	@Autowired
	private Parse parse;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("1");
	}
}
