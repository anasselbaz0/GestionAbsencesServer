package com.absence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absence.entity.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
	
	
}
