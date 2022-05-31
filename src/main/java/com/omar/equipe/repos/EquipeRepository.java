package com.omar.equipe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.omar.equipe.entities.Equipe;
import com.omar.equipe.entities.Ligue;

//@RepositoryRestResource(path = "rest")
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
	List<Equipe> findByNomEquipe(String nom);
	 List<Equipe> findByNomEquipeContains(String nom);
	
	 
	 /*@Query("select p from Equipe p where p.nomEquipe like %:nom and p.budgetEquipe > :prix")
	 List<Equipe> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 */
	 @Query("select p from Equipe p where p.ligue = ?1")
	 List<Equipe> findByLigue (Ligue categorie);
	 
	 List<Equipe> findByLigueIdLigue(Long id);
	 
	// List<Equipe> findByOrderByNomEquipeAsc();
	 
	// @Query("select p from Equipe p order by p.nomEquipe ASC, p.prixEquipe DESC")
	// List<Equipe> trierEquipesNomsPrix ();

}
