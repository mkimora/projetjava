package com.kimoramoussa.kimora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class KimoraApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(KimoraApplication.class, args);
	}

	//mot de passe par défaut
	@Autowired
	PasswordEncoder encoder  ;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(encoder.encode("entrer"));
	}

}
