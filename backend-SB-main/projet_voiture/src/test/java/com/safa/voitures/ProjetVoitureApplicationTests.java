package com.safa.voitures;


import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.entities.Voiture;
import com.safa.voitures.repos.VoitureRepository;
@SpringBootTest
class ProjetVoitureApplicationTests {
	@Autowired
	private VoitureRepository voitureRepository;
	@Test
	public void findBydesignation()
	{
	List<Voiture> voits = voitureRepository.findBydesignation("ford");
	for (Voiture v : voits)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testFindBydesignationContains()
	{
	List<Voiture> voits=voitureRepository.findBydesignationContains("Ford");
	for (Voiture v : voits)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testfindBydesignationPrix()
	{
	List<Voiture> voits = voitureRepository.findBydesignationPrix("ford", 1000.0);
	for (Voiture v : voits)
	{
	System.out.println(v);
	}
	}
	
	@Test
	public void testfindByMarque()
	{
	Marque mq = new Marque();
	mq.setIdmarque(2L);
	List<Voiture> voits = voitureRepository.findByMarque(mq);
	for (Voiture v : voits)
	{
	    System.out.println(v);
	}
	}
	@Test
	public void findByMarqueIdmarque()
	{
	List<Voiture> voits = voitureRepository.findByMarqueIdmarque(2L);
	for (Voiture v : voits)
	{
	System.out.println(v);
	}
	 }
	
}
