package com.omar.equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EquipesProjet2Application implements CommandLineRunner {
	@Autowired
	//private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
	SpringApplication.run(EquipesProjet2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	//repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}
}
