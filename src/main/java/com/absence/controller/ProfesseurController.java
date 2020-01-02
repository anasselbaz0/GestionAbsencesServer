package com.absence.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.absence.entity.Professeur;
import com.absence.entity.User;
import com.absence.service.ProfesseurService;
import com.absence.service.UserService;

@RestController
public class ProfesseurController {

	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/professeurs")
	public List<Professeur> getAllProfesseurs() {
		return professeurService.getAllprofesseurs();
	}
	
	@PostMapping("/professeurs/add")
	public Professeur addOrEditProfesseur(@Valid @RequestBody Professeur prof) {
		prof.setPassword(prof.getPassword());
		User u = prof.toUser();
		userService.saveOrUpdateUser(u);
		return professeurService.addOrEditProfesseur(prof);
	}
	
	@GetMapping("/professeurs/{Id}")
	public Professeur getProfesseurById(@PathVariable("Id") Long id) {
		return professeurService.getProfesseurById(id);
	}
	
	@DeleteMapping("/professeurs/delete/{Id}")
	public void deleteProfesseur(@PathVariable("Id") Long id) {
		Professeur p = professeurService.getProfesseurById(id);
		User u = userService.getUserByUsername(p.getUsername());
		userService.deleteUser(u.getId());
		professeurService.deleteProfesseurById(id);
	}	
}
