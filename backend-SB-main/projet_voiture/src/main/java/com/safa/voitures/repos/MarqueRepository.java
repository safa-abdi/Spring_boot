package com.safa.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safa.voitures.entities.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {


}