package com.omar.equipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.omar.equipe.entities.Ligue;
import com.omar.equipe.repos.LigueRepository;

@Service
public class LigueServiceImpl implements LigueService {


	@Autowired
	LigueRepository categorieRepository ;
	
	@Override
	public List<Ligue> getAllLigues() {
		
		return categorieRepository.findAll();
	}

	@Override
	public Ligue saveLigue(Ligue categorie) {
		
		return categorieRepository.save(categorie);
	}

	@Override
	public Page<Ligue> getAllLiguesParPage(int page, int size) {
		
		return categorieRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteLigueById(Long id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public Ligue getLigues(Long id) {
		
		return categorieRepository.findById(id).get();
	}

	@Override
	public Ligue updateLigues(Ligue c) {
		
		return categorieRepository.save(c);
	}
}
