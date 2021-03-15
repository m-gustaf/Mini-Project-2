package com.blocketlight.BlocketLight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableAutoConfiguration
public class BlocketLightApplication {


	public static void main(String[] args) {
		SpringApplication.run(BlocketLightApplication.class, args);
	}

}
