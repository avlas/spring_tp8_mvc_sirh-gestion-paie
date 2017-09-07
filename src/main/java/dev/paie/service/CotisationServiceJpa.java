package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entity.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Cotisation findById(Integer id) {
		Cotisation cotisation = em.find(Cotisation.class, id);
		return cotisation;
	}
	
	@Override
	@Transactional
	public List<Cotisation> findAll() {
		TypedQuery<Cotisation> query = em.createQuery("from Cotisation", Cotisation.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void save(Cotisation newCotisation) {
		em.persist(newCotisation);
	}
	
	@Override
	@Transactional
	public void update(Cotisation cotisationToUpdate) {
		Cotisation cotisation = findById(cotisationToUpdate.getId());

		if (cotisation != null) {
			cotisation.setCode(cotisationToUpdate.getCode());
			cotisation.setLibelle(cotisationToUpdate.getLibelle());
			cotisation.setTauxPatronal(cotisationToUpdate.getTauxPatronal());
			cotisation.setTauxSalarial(cotisationToUpdate.getTauxSalarial());
		}
	}

}
