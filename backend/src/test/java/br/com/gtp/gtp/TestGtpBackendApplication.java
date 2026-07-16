package br.com.gtp.gtp;

import org.springframework.boot.SpringApplication;

public class TestGtpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(GtpBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
