package com.safa.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.safa.voitures.entities.Marque;

public interface MarqueService {
	Marque saveMarque (Marque m);
	Marque updateMarque (Marque m);
	Marque getMarque(Long id);
	void deleteMarque(Marque m);
	void deleteMarqueById(Long id);
	List<Marque> getAllMarque();
	Page<Marque> getAllMarquesParPage(int page, int size);
}