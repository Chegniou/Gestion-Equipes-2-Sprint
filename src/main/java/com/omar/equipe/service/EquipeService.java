package com.omar.equipe.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.omar.equipe.entities.Equipe;
import com.omar.equipe.entities.Ligue;

public interface EquipeService {

	Equipe saveEquipe(Equipe p);
	Equipe updateEquipe(Equipe p);
	void deleteEquipe(Equipe p);
	void deleteEquipeById(Long id);
	Equipe getEquipe(Long id);
	List<Equipe> getAllEquipes();
	
	
	Page<Equipe> getAllEquipesByLigueParPage(int page, int size, Long id);
	List<Ligue> getAllLigues();
	Page<Equipe> getAllEquipesParPage(int page, int size);
	List<Equipe> findByNomEquipe(String nom);
	List<Equipe> findByNomEquipeContains(String nom);
	//List<Equipe> findByNomPrix (String nom, Double prix);
	//List<Equipe> findByLigue (Ligue categorie);
	List<Equipe> findByLigueIdLigue(Long id);
	/*List<Equipe> findByOrderByNomEquipeAsc();
	List<Equipe> trierEquipesNomsPrix();*/
	
}
