package com.safa.voitures.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.entities.Voiture;
import com.safa.voitures.repos.VoitureRepository;


@Service
public class VoitureServiceImp implements VoitureService{

	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
		return VoitureRepository.findAll(PageRequest.of(page, size));
	}
	@Autowired
	VoitureRepository VoitureRepository;
	@Override
	public Voiture saveVoiture(Voiture v) {
		return VoitureRepository.save(v);

	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return VoitureRepository.save(v);
	}

	@Override
	public void deleteVoiture(Voiture v) {
		VoitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long id) {
		VoitureRepository.deleteById(id);
		
	}

	@Override
	public Voiture getVoiture(Long id) {
		return VoitureRepository.findById(id).get();

	}

	@Override
	public List<Voiture> getAllVoitures() {
		return VoitureRepository.findAll();

	}

	

	@Override
	public List<Voiture> findByMarque(Marque marque) {
		return VoitureRepository.findByMarque(marque);
	}

	@Override
	public List<Voiture> findByMarqueIdmarque(Long id) {
		return VoitureRepository.findByMarqueIdmarque(id);
	}

	@Override
	public List<Voiture> findBydesignation(String nom) {
		return VoitureRepository.findBydesignation(nom);
	}

	@Override
	public List<Voiture> findBydesignationContains(String nom) {
		return VoitureRepository.findBydesignationContains(nom);
	}

	@Override
	public List<Voiture> findBydesignationPrix(String nom, Double prix) {
		return VoitureRepository.findBydesignationPrix(nom, prix);
	}

	
}
