package com.omar.equipe.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omar.equipe.entities.Equipe;
import com.omar.equipe.entities.Ligue;
import com.omar.equipe.service.EquipeService;
import com.omar.equipe.service.LigueService;



@Controller
public class EquipeController {
	@Autowired
	EquipeService produitService;

	@Autowired
	LigueService  categorieService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Ligue> cats = produitService.getAllLigues();
       Equipe prod = new Equipe();
		Ligue cat = new Ligue();
		cat = cats.get(0); // prendre la première catégorie de la liste
		prod.setLigue(cat); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
		modelMap.addAttribute("equipe",prod);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("ligues", cats);
		return "formEquipe";
	}



	@RequestMapping("/saveEquipe")
	public String saveEquipe(@Valid Equipe produit,
							  BindingResult bindingResult)
	{
		System.out.println(produit);
		System.out.println(bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) return "formEquipe";				  
		
		produitService.saveEquipe(produit);	
	return "redirect:ListeEquipes";
	}



	@RequestMapping("/ListeEquipes")
	public String listeEquipes(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		List<Ligue> cats = produitService.getAllLigues();
		Page<Equipe> prods = produitService.getAllEquipesParPage(page, size);
		//Ligue cat = new Ligue();
		// List<Categorie> cats = produitService.getAllCategories();
		modelMap.addAttribute("equipes", prods);
		 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		 modelMap.addAttribute("ligues", cats);
		// modelMap.addAttribute("categories", cats);
		modelMap.addAttribute("currentPage", page);
		return "listeEquipes";

	}
	@RequestMapping("/supprimerEquipe")
	public String supprimerEquipe(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
		produitService.deleteEquipeById(id);
		Page<Equipe> prods = produitService.getAllEquipesParPage(page, 
		size);
		modelMap.addAttribute("equipes", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		
		modelMap.addAttribute("size", size);
		return "listeEquipes";
	}
	
	@RequestMapping("/rechercheEquipe")
	public String rechercheEquipe(@RequestParam("ligue") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size)
    {     
	 	
		System.out.println(id);
		List<Ligue> ts = produitService.getAllLigues();
		modelMap.addAttribute("ligues", ts);
		Page<Equipe> st = produitService.getAllEquipesByLigueParPage(page, size,id);
		modelMap.addAttribute("equipes", st);
		 modelMap.addAttribute("pages", new int[st.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEquipes";
	}
	
	@RequestMapping("/modifierEquipe")
	public String editerEquipe(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Equipe p= 	produitService.getEquipe(id);
		List<Ligue> cats = produitService.getAllLigues();
		modelMap.addAttribute("equipe", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("ligues", cats);
		return "formEquipe";	
	}


	@RequestMapping("/updateEquipe")
	public String updateEquipe(@ModelAttribute("equipe") Equipe produit,ModelMap modelMap) 
	{
		  produitService.updateEquipe(produit);
		  List<Equipe> prods = produitService.getAllEquipes();
		  modelMap.addAttribute("equipes", prods);	
		
		return "listeEquipes";
	}
}

