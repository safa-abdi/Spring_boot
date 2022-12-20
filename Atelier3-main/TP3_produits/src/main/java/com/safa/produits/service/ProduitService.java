package com.safa.produits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.safa.produits.entities.Produit;

public interface ProduitService {
	Page<Produit> getAllProduitsParPage(int page, int size);
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduit(Long id);
	List<Produit> getAllProduits();

}
