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
		
		Avantage avantageToInsert = new Avantage();
		avantageToInsert.setCode("AV01");
		avantageToInsert.setNom("Av1");
		avantageToInsert.setMontant(new BigDecimal("40.40"));
		Avantage insertedAvantage = avantageRepository.save(avantageToInsert);

		Avantage avantageToCheck = avantageRepository.findOne(insertedAvantage.getId());
		assertEquals(avantageToCheck, insertedAvantage);
		
		Avantage updatedAvantage = null;
		if(avantageRepository.exists(insertedAvantage.getId())) {
			insertedAvantage.setCode("AV02");
			insertedAvantage.setNom("Av2");
			insertedAvantage.setMontant(new BigDecimal("30.30"));	
			updatedAvantage = avantageRepository.save(insertedAvantage);
		}

		avantageToCheck = avantageRepository.findOne(updatedAvantage.getId());
		assertEquals(updatedAvantage, avantageToCheck);
		
		Avantage avantageByCode = avantageRepository.findByCode("AV01");
		assertEquals(avantageByCode, avantageToCheck);
	}

}
