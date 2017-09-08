package dev.paie.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERIODES")
public class Periode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DATE_DEBUT")
	private LocalDate dateDebut;
	
	@Column(name="DATE_FIN")
	private LocalDate dateFin;
	
	
	/**
	 * Constructeur par défaut obligatoire pour les @Entity
	 */
	public Periode(){
	}
	
	/** Constructeur: construit une période pour l'année en cours sur la base du numéro de mois passé en paramètre.
	 * La date de début est le 1er de ce mois.
	 * La date de fin est le dernier jour du mois passé en paramètre pour l'année courante.
	 * @param numMois numéro de mois
	 */
	public Periode(int numMois){
		
		int year = LocalDate.now().getYear();
		this.dateDebut = LocalDate.of(year, numMois, 1);
		this.dateFin = dateDebut.withDayOfMonth(dateDebut.lengthOfMonth());
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Periode [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
}
