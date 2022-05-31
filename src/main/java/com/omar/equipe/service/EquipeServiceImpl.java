package com.omar.equipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.omar.equipe.entities.Equipe;
import com.omar.equipe.entities.Ligue;
import com.omar.equipe.repos.EquipeRepository;
import com.omar.equipe.repos.LigueRepository;

@Service
public class EquipeServiceImpl implements EquipeService{
	
	@Autowired
	EquipeRepository produitRepository;
	@Autowired
	LigueRepository categorieRepository;
	@Override
	public Equipe saveEquipe(Equipe p) {
		return produitRepository.save(p);
	}
	@Override
	public Equipe updateEquipe(Equipe p) {
	return produitRepository.save(p);
	}
	@Override
	public void deleteEquipe(Equipe p) {
	produitRepository.delete(p);
	}
	@Override
	public void deleteEquipeById(Long id) {
	produitRepository.deleteById(id);
	}
	@Override
	public Equipe getEquipe(Long id) {
	return produitRepository.findById(id).get();
	}
	@Override
	public List<Equipe> getAllEquipes() {	
	return produitRepository.findAll();
	}
	
	@Override
	public Page<Equipe> getAllEquipesParPage(int page, int size) {
	return produitRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Equipe> findByNomEquipe(String nom) {
	return produitRepository.findByNomEquipe(nom);
	}
	@Override
	public List<Equipe> findByNomEquipeContains(String nom) {
	return produitRepository.findByNomEquipeContains(nom);
	}
	/*@Override
	public List<Equipe> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}*/
	/*@Override
	public List<Equipe> findByLigue(Ligue categorie) {
	return produitRepository.findByLigue(categorie);
	}*/
	@Override
	public List<Equipe> findByLigueIdLigue(Long id) {
	return produitRepository.findByLigueIdLigue(id);
	}/*
	@Override
	public List<Equipe> findByOrderByNomEquipeAsc() {
	return produitRepository.findByOrderByNomEquipeAsc();
	}
	@Override
	public List<Equipe> trierEquipesNomsPrix() {
	return produitRepository.trierEquipesNomsPrix();
	}*/
	
	@Override
	public List<Ligue> getAllLigues() {
		return categorieRepository.findAll();
	}
	
	@Override
	public Page<Equipe> getAllEquipesByLigueParPage(int page, int size, Long id) {
		List<Equipe> list = produitRepository.findByLigueIdLigue(id);
		Page<Equipe> p = new PageImpl<Equipe>(list, PageRequest.of(page, size), list.size());
		return p;
	}
	
	}

