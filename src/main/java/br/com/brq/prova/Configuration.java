package br.com.brq.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Configuration {

	public static void main(String[] args) {
		System.out.println("CCEE PROVA JAVA GETTING UP...");
		SpringApplication.run(Configuration.class, args);
	}
}