package com.absence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.absence.entity.enums.Role;

@Entity
public class Etudiant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String username;
	private String password;
	private String cne;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "id_classe")
	private Classe classe;
	@OneToMany(mappedBy = "etudiant")
	private Collection<Absence> absences;
	
	public Etudiant() {
		super();
		absences = new ArrayList<>();
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



	public String getCne() {
		return cne;
	}



	public void setCne(String cne) {
		this.cne = cne;
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



	public Etudiant(String username, String password, String cne, String nom, Collection<Absence> absences) {
		super();
		this.username = username;
		this.password = password;
		this.cne = cne;
		this.nom = nom;
		this.absences = absences;
	}



	public Etudiant(Long id, String username, String password, String cne, String nom,
			Collection<Absence> absences) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.cne = cne;
		this.nom = nom;
		this.absences = absences;
	}



	public User toUser() {
		return new User(this.username, this.password, Role.ETUDIANT);
	}
	
	
	
	
}
