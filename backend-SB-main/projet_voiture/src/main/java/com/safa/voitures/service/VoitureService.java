package com.safa.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.entities.Voiture;

public interface VoitureService {
	Page<Voiture> getAllVoituresParPage(int page, int size);
	Voiture saveVoiture(Voiture v);
	Voiture updateVoiture(Voiture v);
	void deleteVoiture(Voiture v);
	void deleteVoitureById(Long id);
	Voiture getVoiture(Long id);
	List<Voiture> getAllVoitures();
	List<Voiture> findByMarque (Marque marque);
	 List<Voiture> findByMarqueIdmarque(Long id);
	 List<Voiture> findBydesignation(String nom);
	 List<Voiture> findBydesignationContains(String nom);
	 List<Voiture> findBydesignationPrix (String nom, Double prix);

    

}
