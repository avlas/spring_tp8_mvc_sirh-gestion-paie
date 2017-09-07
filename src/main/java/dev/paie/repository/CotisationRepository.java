package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entity.Cotisation;

public interface CotisationRepository extends JpaRepository<Cotisation, Integer> {

}
