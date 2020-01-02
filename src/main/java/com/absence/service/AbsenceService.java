package com.absence.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absence.entity.Absence;
import com.absence.repository.AbsenceRepository;

@Service
public class AbsenceService {

	@Autowired
	private AbsenceRepository absenceRepository;
	
	public List<Absence> getAllAbsences() {
		return absenceRepository.findAll();
	}

	public Absence getAbsenceById(Long id) {
		return absenceRepository.getOne(id);
	}

	public Absence addOrEditAbsence(@Valid Absence e) {
		return absenceRepository.save(e);
	}

	public void deleteAbsenceById(Long id) {
		absenceRepository.deleteById(id);
	}

}
