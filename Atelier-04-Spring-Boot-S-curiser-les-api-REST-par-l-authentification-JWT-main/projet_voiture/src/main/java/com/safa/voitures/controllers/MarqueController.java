package com.safa.voitures.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.service.MarqueService;

@Controller
public class MarqueController {

	@Autowired
	MarqueService marqueService;
	
	@RequestMapping("/ListeMarques")
	public String ListeM(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "4") int size)
	{
	Page<Marque> mqs = marqueService.getAllMarquesParPage(page, size);
	modelMap.addAttribute("marques", mqs);
	 modelMap.addAttribute("pages", new int[mqs.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "ListeMarques";
	}
	@RequestMapping("/supprimerMarque")

	public String supprimerMarque(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
			{
			marqueService.deleteMarqueById(id);
			Page<Marque> mqs = marqueService.getAllMarquesParPage(page, 
			size);
			modelMap.addAttribute("marques", mqs);
			modelMap.addAttribute("pages", new int[mqs.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeMarques";
			}
	@RequestMapping("/editerMarque")
	public String editerMarque(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Marque m= 	marqueService.getMarque(id);
		modelMap.addAttribute("marque", m);	
		return "editerMarque";	
	}
	@RequestMapping("/saveMarque")
	public String saveMarque(@Valid Marque marque, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "CreateMarque";
		marqueService.saveMarque(marque);
		return "editerMarque";
	}
	@RequestMapping("/CreateMarque")
	public String create(ModelMap modelMap)
	{
		modelMap.addAttribute("marque", new Marque());
		return "CreateMarque";
	}
}
