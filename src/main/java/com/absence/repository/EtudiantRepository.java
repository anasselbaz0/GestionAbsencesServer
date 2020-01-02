package com.absence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absence.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	Etudiant findByUsername(String username);
	
}
