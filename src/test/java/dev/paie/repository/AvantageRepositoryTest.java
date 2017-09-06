package dev.paie.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class})
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;
	
	@Test
	public void test_save_list_update() {
		
		Avantage avantage = new Avantage();
		avantage.setCode("AV01");
		avantage.setNom("Av1");
		avantage.setMontant(new BigDecimal("40.40"));
		avantageRepository.save(avantage);

		Avantage av2 = avantageRepository.findOne(avantage.getId());
		assertEquals(avantage, av2);
		
		if(avantageRepository.exists(avantage.getId())) {
			avantage.setCode("AV02");
			avantage.setNom("Av2");
			avantage.setMontant(new BigDecimal("30.30"));	
			avantageRepository.save(avantage);
		}

		Avantage av3 = avantageRepository.findOne(avantage.getId());
		assertEquals(avantage, av3);
	}

}
