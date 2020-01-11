package com.absence.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.absence.entity.Classe;
import com.absence.service.ClasseService;

@RestController
public class ClasseController {
	
	@Autowired
	ClasseService classeService;
	
	@GetMapping("/classes")
	public List<Classe> getAllEtudiants() {
		return classeService.getAllclasses();
	}
	
	@GetMapping("/classes/filiere/{f}")
	public List<Classe> getByFiliere(@PathVariable("f") String filiere) {
		return classeService.getByFiliere(filiere);
	}
	
	@GetMapping("/classes/{id}")
	public Optional<Classe> getEtudiantById(@PathVariable("id") Long id) {
		Optional<Classe> c =  classeService.getClasseById(id);
		return c;
	}
	
	@PostMapping("/classes/add")
	public Classe addOrEditEtudiant(@Valid @RequestBody Classe c) {
		return classeService.addOrEditClasse(c);
	}
	
	@DeleteMapping("/classes/delete/{id}")
	public void deleteClasseById(@PathVariable("id") Long id) {
		classeService.deleteClasseById(id);
	}
	

}
