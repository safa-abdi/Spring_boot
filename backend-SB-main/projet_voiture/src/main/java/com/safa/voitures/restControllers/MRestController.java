package com.safa.voitures.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.safa.voitures.entities.Marque;
import com.safa.voitures.service.MarqueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Mapi")
public class MRestController {
@Autowired
MarqueService marqueService;
@RequestMapping(method = RequestMethod.GET)
public List<Marque> getAllMarques()
	{    return marqueService.getAllMarque();		}
@RequestMapping(method = RequestMethod.POST)
public Marque createMarque(@RequestBody Marque marque) {
		return marqueService.saveMarque(marque);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteMarque(@PathVariable("id") Long id)
{
	marqueService.deleteMarqueById(id);
}
@RequestMapping(method = RequestMethod.PUT)
public Marque updateMarque(@RequestBody Marque marque) {
	return marqueService.updateMarque(marque);
	}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Marque getMarqueById(@PathVariable("id") Long id) {
return marqueService.getMarque(id);
}

}
