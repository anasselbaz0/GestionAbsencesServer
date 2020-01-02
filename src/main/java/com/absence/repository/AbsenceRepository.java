package com.absence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absence.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

}
