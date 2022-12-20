package com.safa.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.entities.Voiture;
import com.safa.voitures.repository.VoitureRepository;

@SpringBootTest
class Tp2VoituresApplicationTests {
	@Autowired
	private VoitureRepository voitureRepository;
	@Test
	public void testCreateVoiture() {
	Voiture voits = new Voiture("ford aa",200.500,new Date());
	voitureRepository.save(voits);
	}
	@Test
	public void testFindVoiture()
	{
	Voiture v = voitureRepository.findById(6L).get();
	System.out.println(v);
	}
	@Test
	public void testFindByNomVoiture()
	{
	List<Voiture> voits = voitureRepository.findByNomVoiture("ford fiesta");

	for (Voiture v : voits)
	{
	System.out.println(v);
	}

	}
	@Test
	public void testFindByNomVoitureContains ()
	{
	List<Voiture> voits=voitureRepository.findByNomVoitureContains("ford");

	for (Voiture v : voits)
	{
	System.out.println(v);
	} }
	@Test
	public void testfindByNomPrix()
	{
	List<Voiture> voits = voitureRepository.findByNomPrix("ford focus", 10.00);
	for (Voiture v : voits)
	{
	System.out.println(v);
	}

	}
	@Test
	public void testfindByMarque()
	{
	Marque mq = new Marque();
	mq.setIdMq(1L);
	List<Voiture> voits = voitureRepository.findByMarque(mq);
	for (Voiture v : voits)
	{
	System.out.println(v);
	}

	}
	@Test
	public void findByMarqueIdMq()
	{
	List<Voiture> voits = voitureRepository.findByMarqueIdMq(1L);
	for (Voiture v : voits)
	{
	System.out.println(v);
	}

	}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Voiture> voits =voitureRepository.findByOrderByNomVoitureAsc();
	for (Voiture v : voits)
	{
	System.out.println(v);
	}

	}
	@Test
	public void testTrierVoituresNomsPrix()
	{
	List<Voiture> voits = voitureRepository.trierVoituresNomsPrix();
	for (Voiture v : voits)
	{
	System.out.println(v);
	}

	}

}
