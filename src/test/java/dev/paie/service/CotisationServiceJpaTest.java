package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

//	@Qualifier("sp01")
//	private Cotisation sp01Cotisation;
	
	@Test
	public void test_save_list_update() {
//		cotisationService.save(sp01Cotisation);
//		
//		List<Cotisation> cotisations1 = cotisationService.findAll();
//		assertTrue(cotisations1.contains(sp01Cotisation));
//		assertTrue(!cotisations1.isEmpty());
		
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("SP01");
		cotisation.setLibelle("URSSAF CSG NON DEDUCTIBLE");
		cotisation.setTauxPatronal(new BigDecimal("12.12"));
		cotisation.setTauxSalarial(new BigDecimal("172.17"));
		cotisationService.save(cotisation);
		
		List<Cotisation> cotisations = cotisationService.findAll();
		assertTrue(cotisations.contains(cotisation));
		assertTrue(!cotisations.isEmpty());

		cotisation.setCode("SP02");
		cotisation.setLibelle("URSSAF DEDUCTIBLE");
		cotisation.setTauxPatronal(new BigDecimal("20.20"));
		cotisation.setTauxSalarial(new BigDecimal("50.50"));
		cotisationService.update(cotisation);
		
		Cotisation cotisationUpdated = cotisationService.findById(cotisation.getId());
		assertEquals("SP02", cotisationUpdated.getCode());
		assertEquals("URSSAF DEDUCTIBLE", cotisationUpdated.getLibelle());
		assertEquals(new BigDecimal("20.20"), cotisationUpdated.getTauxPatronal());
		assertEquals(new BigDecimal("50.50"), cotisationUpdated.getTauxSalarial());
	}

}
