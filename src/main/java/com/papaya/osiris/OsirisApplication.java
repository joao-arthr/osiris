package com.papaya.osiris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OsirisApplication {
	public static void main(String[] args) {
		SpringApplication.run(OsirisApplication.class, args);
	}

}
