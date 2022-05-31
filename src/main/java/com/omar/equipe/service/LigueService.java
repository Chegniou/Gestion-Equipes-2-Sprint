package com.omar.equipe.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.omar.equipe.entities.Ligue;

public interface LigueService {
	
	List<Ligue> getAllLigues();
	Ligue saveLigue(Ligue categorie);
	Page<Ligue> getAllLiguesParPage(int i, int j);
	void deleteLigueById(Long id);
	Ligue getLigues(Long id);
	Ligue updateLigues(Ligue c);

}
