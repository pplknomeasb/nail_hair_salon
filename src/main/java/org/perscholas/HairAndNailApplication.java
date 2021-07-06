package org.perscholas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HairAndNailApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairAndNailApplication.class, args);
	}

}
