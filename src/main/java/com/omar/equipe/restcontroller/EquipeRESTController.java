package com.omar.equipe.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omar.equipe.entities.Equipe;
import com.omar.equipe.service.EquipeService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipeRESTController {

	@Autowired
	EquipeService produitService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Equipe> getAllEquipes() {
	return produitService.getAllEquipes();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Equipe getEquipeById(@PathVariable("id") Long id) {
	return produitService.getEquipe(id);
	 }

	@RequestMapping(method = RequestMethod.POST)
	public Equipe createEquipe(@RequestBody Equipe produit) {
	return produitService.saveEquipe(produit);
	}



	@RequestMapping(method = RequestMethod.PUT)
	public Equipe updateEquipe(@RequestBody Equipe produit) {
	return produitService.updateEquipe(produit);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEquipe(@PathVariable("id") Long id)
	{
	produitService.deleteEquipeById(id);
	}

	@RequestMapping(value="/prodscat/{idLigue}",method = RequestMethod.GET)
	public List<Equipe> getEquipesByLigueId(@PathVariable("idLigue") Long idCat) {
	return produitService.findByLigueIdLigue(idCat);
	}


	
}
