package com.omar.equipe.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omar.equipe.entities.Role;
import com.omar.equipe.entities.User;
import com.omar.equipe.security.SecurityConfig;
import com.omar.equipe.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService  categorieService;
	
	/*	@RequestMapping("/showCreateUser")
	public String showCreateUser(ModelMap modelMap)
	{
		modelMap.addAttribute("User", new User());
		modelMap.addAttribute("mode", "new");
		return "formUser";
	}
	
	
	@RequestMapping("/saveUser")
	public String saveCategorie(@Valid User categorie,
	BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formUser";
		 
		categorieService.saveUser(categorie);
		return "redirect:/ListeUser";
	}
	*/
	
	@RequestMapping("/ListeUsers")
	public String listeUsers(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
	Page<User> cat = categorieService.getAllUsersParPage(page, size);
	
	modelMap.addAttribute("Users", cat);
	 modelMap.addAttribute("pages", new int[cat.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeUsers"; 
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		SecurityConfig sec = new SecurityConfig();
		 PasswordEncoder passwordEncoder = sec.passwordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		categorieService.updateUsers(user);
	 List<User> ue= categorieService.getAllUsers();
	 List<Role> role = categorieService.getRoles();
	 modelMap.addAttribute("users", ue);
	modelMap.addAttribute("listeroles",role);
	return "listeUsers";
	}
	
	@RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id,ModelMap modelMap)
	{
	User u= categorieService.getUsers(id);
	List<Role> role = categorieService.getRoles();
	modelMap.addAttribute("users", u);
	modelMap.addAttribute("listeroles",role);
	modelMap.addAttribute("mode", "edit");

	return "formUser";
	}
	
	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		User user =categorieService.getUsers(id);
		user.setRoles(null);
		categorieService.updateUsers(user);
		categorieService.deleteUserById(id);
		Page<User> u = categorieService.getAllUsersParPage(page,
				size);
		modelMap.addAttribute("Users", u);
		modelMap.addAttribute("pages", new int[u.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeUsers";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid User user, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formUser";
	SecurityConfig sec = new SecurityConfig();
	PasswordEncoder passwordEncoder = sec.passwordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//user.setEnabled(true);

		categorieService.saveUser(user);
	return "redirect:/ListeUsers";
	}
	
	@RequestMapping("/showCreateUser")
	public String showCreateU(ModelMap modelMap)
	{
		
	modelMap.addAttribute("user", new User());

	List<Role> role = categorieService.getRoles();
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("listeroles",role);
	return "formUser";
	}
	/*	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
		categorieService.deleteUserById(id);
	Page<User> cat = categorieService.getAllUsersParPage(page, size);
	modelMap.addAttribute("Users", cat);
	modelMap.addAttribute("pages", new int[cat.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeUsers";
	}
	
  @RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id,ModelMap modelMap)
	{
		User c= categorieService.getUsers(id);
	modelMap.addAttribute("User", c);
	modelMap.addAttribute("mode", "edit");
	return "formUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("User") User categorie,
	
	ModelMap modelMap) throws ParseException 
	{
	
		
	 categorieService.updateUsers(categorie);
	 List<User> cat = categorieService.getAllUsers();
	 modelMap.addAttribute("Users", cat);
	 
	    
	return "listeUsers";
	
}*/
	
}
