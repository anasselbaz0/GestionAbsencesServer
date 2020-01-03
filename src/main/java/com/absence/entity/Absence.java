package com.absence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Absence {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean isJustified;
	@ManyToOne
	@JoinColumn(name = "id_module")
	private Module module;
	@ManyToOne
	@JoinColumn(name = "id_etudiant")
	private Etudiant etudiant;
	@ManyToOne
	@JoinColumn(name = "id_professeur")
	private Professeur professeur;
	
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Absence(Long id, Boolean isJustified, Module module, Etudiant etudiant, Professeur professeur) {
		super();
		this.id = id;
		this.isJustified = isJustified;
		this.module = module;
		this.etudiant = etudiant;
		this.professeur = professeur;
	}

	public Absence(Boolean isJustified, Module module, Etudiant etudiant, Professeur professeur) {
		super();
		this.isJustified = isJustified;
		this.module = module;
		this.etudiant = etudiant;
		this.professeur = professeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsJustified() {
		return isJustified;
	}

	public void setIsJustified(Boolean isJustified) {
		this.isJustified = isJustified;
	}

	
	
	
	

}
