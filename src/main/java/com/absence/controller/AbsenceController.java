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

import com.absence.entity.Absence;
import com.absence.service.AbsenceService;

@RestController
public class AbsenceController {

	@Autowired
	private AbsenceService absenceService;
	
	@GetMapping("/absences")
	public List<Absence> getAllAbsences() {
		return absenceService.getAllAbsences();
	}
	
	@GetMapping("/absences/{id}")
	public Absence getAbsenceById(@PathVariable("id") Long id) {
		Absence e = absenceService.getAbsenceById(id);
		return e;
	}
	
	@PostMapping("/absences/add")
	public Absence addOrEditAbsence(@Valid @RequestBody Absence e) {
		return absenceService.addOrEditAbsence(e);
	}
	
	@DeleteMapping("/absences/delete/{id}")
	public void deleteAbsenceById(@PathVariable("id") Long id) {
		absenceService.deleteAbsenceById(id);
	}
	
}
