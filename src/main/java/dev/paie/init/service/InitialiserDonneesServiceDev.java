package dev.paie.init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import dev.paie.entity.BulletinSalaire;
import dev.paie.entity.Cotisation;
import dev.paie.entity.Entreprise;
import dev.paie.entity.Grade;
import dev.paie.entity.Periode;
import dev.paie.entity.ProfilRemuneration;
import dev.paie.entity.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
// Marque un bean de configuration Spring
@ImportResource({ "classpath:entreprises.xml", 
	"classpath:grades.xml", 
	"classpath:profils-remuneration.xml"})
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private CotisationRepository cotisationRepository;

	@Autowired
	private List<Cotisation> cotisations;

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Autowired
	private List<Entreprise> entreprises;

	@Autowired
	private GradeRepository gradeRepository;

	@Autowired
	private List<Grade> grades;

	@Autowired
	private PeriodeRepository periodeRepository;

//	@Autowired
//	private List<Periode> periodes;

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;

	@Autowired
	private List<ProfilRemuneration> profils;

//	@Autowired
//	private BulletinSalaireRepository bulletinSalaireRepository;
//
//	@Autowired
//	private List<BulletinSalaire> bulletins;
//
//	@Autowired
//	private RemunerationEmployeRepository renumerationEmployeRepository;
//
//	@Autowired
//	private List<RemunerationEmploye> remunerations;

	// @Autowired
	// private AvantageRepository avantageRepository;

	// @Autowired
	// private List<Avantage> avantages;

	@Override
	public void initialiser() {
		for (Cotisation cotisation : cotisations) {
			cotisationRepository.save(cotisation);
		}
		for (Entreprise entreprise : entreprises) {
			entrepriseRepository.save(entreprise);
		}

		for (Grade grade : grades) {
			gradeRepository.save(grade);
		}

		for (int i = 1; i <= 12; i++) {
			periodeRepository.save(new Periode(i));
		}

		for (ProfilRemuneration profil : profils) {
			profilRemunerationRepository.save(profil);
		}
//
//		for (RemunerationEmploye remuneration : remunerations) {
//			renumerationEmployeRepository.save(remuneration);
//		}
//
//		for (BulletinSalaire bulletin : bulletins) {
//			bulletinSalaireRepository.save(bulletin);
//		}

		// for (Avantage avantage : avantages) {
		// avantageRepository.save(avantage);
		// }

	}

}
