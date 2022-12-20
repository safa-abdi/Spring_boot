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
	Marque saveMarque(Marque m);


}
