package com.absence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absence.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}
