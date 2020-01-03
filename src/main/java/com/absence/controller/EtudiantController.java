package com.absence.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.absence.entity.Etudiant;
import com.absence.entity.User;
import com.absence.service.EtudiantService;
import com.absence.service.UserService;

@RestController
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEtudiants() {
		return etudiantService.getAllEtudiants();
	}
	
	@GetMapping("/etudiants/{id}")
	public Etudiant getEtudiantById(@PathVariable("id") Long id) {
		Etudiant e =  etudiantService.getEtudiantById(id);
		return e;
	}
	
	@GetMapping("/etudiants/username/{username}")
	public Etudiant getEtudiantByUsername(@PathVariable("username") String u) {
		System.out.println(u);
		Etudiant e =  etudiantService.getEtudiantByUsername(u);
		return e;
	}
	
	@PostMapping("/etudiants/add")
	public Etudiant addOrEditEtudiant(@Valid @RequestBody Etudiant e) {
		e.setPassword(e.getPassword());
		User u = e.toUser();
		userService.saveOrUpdateUser(u);
		return etudiantService.addOrEditEtudiant(e);
	}
	
	@DeleteMapping("/etudiants/delete/{id}")
	public void deleteEtudiantById(@PathVariable("id") Long id) {
		//userService.deleteUserById(etudiantService.g);
		etudiantService.deleteEtudiantById(id);
	}
	
}
