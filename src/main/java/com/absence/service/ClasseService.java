package com.absence.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absence.entity.Classe;
import com.absence.repository.ClasseRepository;

@Service
public class ClasseService {
	
	@Autowired
	private ClasseRepository classeRepository;
	
	public Classe addOrEditClasse(Classe classe) {
		return classeRepository.save(classe);
	}
	
	public void deleteClasse(Long id) {
		classeRepository.deleteById(id);
	}
	
	public Optional<Classe> getClasseById(Long id) {
		return classeRepository.findById(id);
	}
	
	public List<Classe> getAllclasses() {
		List<Classe> l = classeRepository.findAll();
		return l;
	}
	
	public void deleteClasseById(Long id) {
		classeRepository.deleteById(id);
	}

	public List<Classe> getByFiliere(String filiere) {
		List<Classe> l = classeRepository.findAll();
		List<Classe> out = new ArrayList<>();
		for(int i=0; i<l.size(); i++) {
			Classe c = l.get(i);
			if(c.getCycle().toString().equals(filiere)) {
				out.add(c);
			}
		}
		return out;
	}
	

}
