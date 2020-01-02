package com.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absence.entity.Professeur;
import com.absence.repository.ProfesseurRepository;

@Service
public class ProfesseurService {
	
	@Autowired
	ProfesseurRepository professeurRep;
	
	public Professeur addOrEditProfesseur(Professeur professeur) {
		return professeurRep.save(professeur);
	}
	public void deleteProfesseurById(Long id) {
		professeurRep.deleteById(id);
	}
	
	public List<Professeur> getAllprofesseurs() {
		List<Professeur> l = professeurRep.findAll();
		return l;
	}

	public Professeur getProfesseurById(Long id) {
		return professeurRep.getOne(id);
	}

}
