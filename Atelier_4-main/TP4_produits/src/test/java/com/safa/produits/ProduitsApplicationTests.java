package com.safa.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.safa.produits.entities.Categorie;
import com.safa.produits.entities.Produit;
import com.safa.produits.repos.ProduitRepository;
import com.safa.produits.service.ProduitService;


@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ProduitService produitService;

	@Test
	public void testCreateProduit() {
	Produit prod = new Produit("PC hp",1400.500,new Date());
	produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit()
	{
		List<Produit> prods = produitRepository.findByNomProduit("imprimante");
		
		for (Produit p:prods)
			 System.out.println(p);

	}
	
	@Test
	public void testUpdateProduit()
	{
	Produit p = produitRepository.findById(1L).get();
	p.setPrixProduit(2000.0);
	produitRepository.save(p);
	
	System.out.println(p);
	}
	
	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllProduits()
	{
		List<Produit> prods = produitRepository.findAll();
		
		for (Produit p:prods)
			 System.out.println(p);
		
	}
	@Test
	public void testFindByNomProduitContains()
	{
	List<Produit> prods = produitRepository.findByNomProduitContains("h");
		
		for (Produit p:prods)
			 System.out.println(p);
		
	}
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("pc sony", 4500);
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Produit> prods = produitRepository.findByCategorie(cat);
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Produit> prods =

	produitRepository.findByOrderByNomProduitAsc();
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Produit> prods = produitRepository.trierProduitsNomsPrix();
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	
}
