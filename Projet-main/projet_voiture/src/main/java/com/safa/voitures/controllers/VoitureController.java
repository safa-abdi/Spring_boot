package com.safa.voitures.controllers;

import java.sql.Date;
import java.text.ParseException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.entities.Voiture;
import com.safa.voitures.service.VoitureService;

@Controller
public class VoitureController {
	@Autowired
	VoitureService voitureService;	

	@RequestMapping("/CreateVoiture")
	public String create(ModelMap modelMap)
	{
		modelMap.addAttribute("voiture", new Voiture());
		return "CreateVoiture";
	}

	@RequestMapping("/ListeVoitures")
	public String ListeVoitures(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "4") int size)
	{
	Page<Voiture> voits = voitureService.getAllVoituresParPage(page, size);
	modelMap.addAttribute("voitures", voits);
	 modelMap.addAttribute("pages", new int[voits.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeVoitures";
	}
	@RequestMapping("/supprimerVoiture")

	public String supprimerVoiture(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
			{
			voitureService.deleteVoitureById(id);
			Page<Voiture> voits = voitureService.getAllVoituresParPage(page, 
			size);
			modelMap.addAttribute("voitures", voits);
			modelMap.addAttribute("pages", new int[voits.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeVoitures";
			}
	@RequestMapping("/detailsVoiture")
	public String detailsVoiture(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
	{
		voitureService.getVoiture(id);
	Page<Voiture> voits = voitureService.getAllVoituresParPage(page, size);
	modelMap.addAttribute("voitures", voits);
	 modelMap.addAttribute("pages", new int[voits.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "details";
	}
	@RequestMapping("/details")
	public String detailer(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Voiture voit = voitureService.getVoiture(id);
		modelMap.addAttribute("voiture", voit);	
		return "details";	
	}

	@RequestMapping("/updateVoiture")
	public String updateVoiture(@ModelAttribute("voiture") Voiture voiture,
			                    ModelMap modelMap) throws ParseException 
	{
	    
		  voitureService.updateVoiture(voiture);
		  List<Voiture> voits = voitureService.getAllVoitures();
		  modelMap.addAttribute("voitures", voits);	
		
		return "listeVoiture";
	}
	@RequestMapping("/saveVoiture")
	public String saveVoiture(@Valid Voiture voiture,
			 BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "CreateVoiture";
		voitureService.saveVoiture(voiture);
     
		return "CreateVoiture";
	}
	
	@RequestMapping("/editerVoiture")
	public String editerVoiture(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Voiture v= 	voitureService.getVoiture(id);
		modelMap.addAttribute("voiture", v);	
		return "editerVoiture";	
	}

}

