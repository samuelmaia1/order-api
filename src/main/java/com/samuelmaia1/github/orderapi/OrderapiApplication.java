package com.samuelmaia1.github.orderapi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class OrderapiApplication {

	public static void main(String[] args) {

		//SpringApplication.run(OrderapiApplication.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(OrderapiApplication.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.run(args);

	}

}
