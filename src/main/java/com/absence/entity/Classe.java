package com.absence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.absence.entity.enums.Annee;
import com.absence.entity.enums.Cycle;
import com.absence.entity.enums.Filiere;

@Entity
public class Classe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Cycle cycle;
	private Annee annee;
	private Filiere filiere;
	private int groupe;
	@OneToMany(mappedBy = "classe")
	private Collection<Etudiant> etudiants;
	
	@Override
	public String toString() {
		return "Classe [id=" + id + ", cycle=" + cycle + ", annee=" + annee + ", filiere=" + filiere + ", groupe="
				+ groupe + ", etudiants=" + etudiants + "]";
	}

	public Classe() {
		super();
		etudiants = new ArrayList<>();
	}

	public Classe(Long id, Cycle cycle, Annee annee, Filiere filiere, int groupe, Collection<Etudiant> etudiants) {
		super();
		this.id = id;
		this.cycle = cycle;
		this.annee = annee;
		this.filiere = filiere;
		this.groupe = groupe;
		this.etudiants = etudiants;
	}

	public Classe(Cycle cycle, Annee annee, Filiere filiere, int groupe, Collection<Etudiant> etudiants) {
		super();
		this.cycle = cycle;
		this.annee = annee;
		this.filiere = filiere;
		this.groupe = groupe;
		this.etudiants = etudiants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}