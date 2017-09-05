package dev.paie.service;

import java.util.List;

import dev.paie.entite.Cotisation;

public interface CotisationService {
	
	Cotisation findById(Integer id);
	
	List<Cotisation> findAll();
	
	void save(Cotisation newCotisation);

	void update(Cotisation cotisation);	

}
