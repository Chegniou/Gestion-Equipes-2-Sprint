package com.omar.equipe.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omar.equipe.entities.Ligue;
import com.omar.equipe.service.LigueService;



@Controller
public class LigueController {
	@Autowired
	LigueService  categorieService;
	
	@RequestMapping("/showCreateligue")
	public String showCreateLigue(ModelMap modelMap)
	{
		modelMap.addAttribute("ligue", new Ligue());
		modelMap.addAttribute("mode", "new");
		return "formLigue";
	}
	
	
	@RequestMapping("/saveLigue")
	public String saveCategorie(@Valid Ligue categorie,
	BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formLigue";
		 
		categorieService.saveLigue(categorie);
		return "redirect:/ListeLigue";
	}
	
	
	@RequestMapping("/ListeLigue")
	public String listeLigues(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
	Page<Ligue> cat = categorieService.getAllLiguesParPage(page, size);
	modelMap.addAttribute("ligues", cat);
	 modelMap.addAttribute("pages", new int[cat.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeLigues"; 
	}
	
	
	@RequestMapping("/supprimerLigue")
	public String supprimerLigue(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
		categorieService.deleteLigueById(id);
	Page<Ligue> cat = categorieService.getAllLiguesParPage(page, size);
	modelMap.addAttribute("ligues", cat);
	modelMap.addAttribute("pages", new int[cat.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeLigues";
	}
	
	@RequestMapping("/modifierLigue")
	public String editerLigue(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Ligue c= categorieService.getLigues(id);
	modelMap.addAttribute("ligue", c);
	modelMap.addAttribute("mode", "edit");
	return "formLigue";
	}

	@RequestMapping("/updateLigue")
	public String updateLigue(@ModelAttribute("ligue") Ligue categorie,
	
	ModelMap modelMap) throws ParseException 
	{
	
		
	 categorieService.updateLigues(categorie);
	 List<Ligue> cat = categorieService.getAllLigues();
	 modelMap.addAttribute("ligues", cat);
	 
	    
	return "listeLigues";
	
}
}
