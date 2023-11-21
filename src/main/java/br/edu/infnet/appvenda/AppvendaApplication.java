package br.edu.infnet.appvenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppvendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppvendaApplication.class, args);
	}

}
