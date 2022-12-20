package com.safa.voitures.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.repos.MarqueRepository;

@Service
public class MarqueServiceImp implements MarqueService{
@Autowired
	MarqueRepository marqueRepository;
	@Override
	public Marque saveMarque(Marque m) {
		return marqueRepository.save(m);
	}

	@Override
	public Marque updateMarque(Marque m) {
		return marqueRepository.save(m);

	}

	@Override
	public List<Marque> getAllMarque() {
		return marqueRepository.findAll();

	}


	@Override
	public Marque getMarque(Long id) {
		return marqueRepository.findById(id).get();
	}

	@Override
	public Page<Marque> getAllMarquesParPage(int page, int size) {
		return marqueRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteMarque(Marque m) {
		marqueRepository.delete(m);
		
	}

	@Override
	public void deleteMarqueById(Long id) {
		marqueRepository.deleteById(id);
		
	}

	
}
