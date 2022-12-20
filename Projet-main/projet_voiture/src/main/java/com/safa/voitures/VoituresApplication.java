package com.safa.voitures;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safa.voitures.entities.Voiture;
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
	voitureService.saveVoiture(new Voiture("ford focus",new Date(),88.800,"gris-blanc","disponible",5,5,5,4,"Essence","6 cv","Manuelle",4040,1775,1450));
	voitureService.saveVoiture(new Voiture("Skoda KAMIQ",new Date(),77.980,"noir-gris-blanc","2 mois",5,5,5,4,"Essence","8 cv","Automatique",4040,1775,1450));

	}
}
