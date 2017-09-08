package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.spring.jpa.orm.JpaConfig;
import dev.paie.config.spring.jpa.orm.jdbc.mysql.MySQLDataSourceConfig;
import dev.paie.config.spring.service.ServicesConfig;
import dev.paie.entity.BulletinSalaire;
import dev.paie.entity.ResultatCalculRemuneration;

@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class, MySQLDataSourceConfig.class, JeuxDeDonneesConfig.class })	// Sélection des classes de configuration Spring à utiliser lors du test
@RunWith(SpringRunner.class)			// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
public class CalculerRemunerationServiceSimpleTest {

	@Autowired
	private CalculerRemunerationService remunerationService;

	// pas besoin de @Component sur BulletinSalaire car il est injecte cree en XML :jdd-config.xml
	@Autowired
	private BulletinSalaire bulletin;		

	@Test
	public void test_calculer() {
		// TODO remplacer null par un objet bulletin

		ResultatCalculRemuneration resultat = remunerationService.calculer(bulletin);
		assertThat(resultat.getSalaireBrut(), equalTo("2682.03"));
		assertThat(resultat.getTotalRetenueSalarial(), equalTo("516.83"));
		assertThat(resultat.getTotalCotisationsPatronales(), equalTo("1095.61"));
		assertThat(resultat.getNetImposable(), equalTo("2165.20"));
		assertThat(resultat.getNetAPayer(), equalTo("1508.11"));
	}

}
