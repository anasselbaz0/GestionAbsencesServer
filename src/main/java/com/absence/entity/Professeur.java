package com.absence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.absence.entity.enums.Role;

@Entity
public class Professeur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String username;
	private String password;
	private String nom;
	@OneToMany(mappedBy = "professeur")
	private Collection<Absence> absences;
	
	public Professeur() {
		super();
		absences = new ArrayList<>();
	}

	

	public Professeur(String username, String password, String nom, Collection<Absence> absences) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.absences = absences;
	}



	public Professeur(Long id, String username, String password, String nom, Collection<Absence> absences) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.absences = absences;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	public User toUser() {
		return new User(this.getUsername(),this.getPassword(),Role.PROFESSEUR);
	}
	
}
