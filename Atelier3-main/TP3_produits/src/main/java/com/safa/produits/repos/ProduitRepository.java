package com.safa.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safa.produits.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
