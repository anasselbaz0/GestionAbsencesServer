package com.absence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Module implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "module")
	private Collection<Absence> absences;
	
	public Module() {
		super();
		absences = new ArrayList<>();
	}

	public Module(Long id, String nom, Collection<Absence> absences) {
		super();
		this.id = id;
		this.nom = nom;
		this.absences = absences;
	}

	public Module(String nom, Collection<Absence> absences) {
		super();
		this.nom = nom;
		this.absences = absences;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
