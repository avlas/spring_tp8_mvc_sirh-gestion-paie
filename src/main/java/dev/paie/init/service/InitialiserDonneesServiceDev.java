package dev.paie.init.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import dev.paie.repository.AvantageRepository;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
// Marque un bean de configuration Spring
@ImportResource({"classpath:cotisations-imposables.xml", 
	"classpath:cotisations-non-imposables.xml", 
	"classpath:entreprises.xml", 
	"classpath:grades.xml",  
	"classpath:profils-remuneration.xml"})	
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private AvantageRepository avantageRepository;
	
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	private CotisationRepository cotisationRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
		
	@Autowired
	private RemunerationEmployeRepository renumerationEmployeRepository;
	
	@Override
	public void initialiser() {
		// TODO Auto-generated method stub

	}

}
