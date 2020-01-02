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

import com.absence.entity.Module;
import com.absence.service.ModuleService;

@RestController
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	@GetMapping("/modules")
	public List<Module> getAllModules() {
		return moduleService.getAllModules();
	}
	
	@GetMapping("/modules/{id}")
	public Module getModuleById(@PathVariable("id") Long id) {
		Module e =  moduleService.getModuleById(id);
		return e;
	}
	
	@PostMapping("/modules/add")
	public Module addOrEditModule(@Valid @RequestBody Module e) {
		return moduleService.addOrEditModule(e);
	}
	
	@DeleteMapping("/modules/delete/{id}")
	public void deleteModuleById(@PathVariable("id") Long id) {
		moduleService.deleteModuleById(id);
	}
	
}
