package com.omar.equipe.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;






@Entity
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String nomEquipe;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double budget;
	
	
	private Long Champions;
	
	@PastOrPresent
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreation;
	
	@ManyToOne
	private Ligue ligue;
	
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public Long getChampions() {
		return Champions;
	}
	public void setChampions(Long champions) {
		Champions = champions;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	public Ligue getLigue() {
		return ligue;
	}
	public void setLigue(Ligue ligue) {
		this.ligue = ligue;
	}
	public Equipe(String nomEquipe, Double budget, Long champions, Date dateCreation) {
		super();
		this.nomEquipe = nomEquipe;
		this.budget = budget;
		Champions = champions;
		this.dateCreation = dateCreation;
	}
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", budget=" + budget + ", Champions="
				+ Champions + ", dateCreation=" + dateCreation + "]";
	}
	
}
