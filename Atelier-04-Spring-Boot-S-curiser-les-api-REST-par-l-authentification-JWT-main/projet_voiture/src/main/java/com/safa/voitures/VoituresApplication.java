package com.safa.voitures;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safa.voitures.service.VoitureService;

@SpringBootApplication
public class VoituresApplication implements CommandLineRunner {
	@Autowired
	VoitureService voitureService;
	
	public static void main(String[] args) {
		SpringApplication.run(VoituresApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	
	}
}
