package dev.paie.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.config.spring.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class, ServicesConfig.class, JeuxDeDonneesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Before
	public void setup() {
		gradeService.truncateTable();
	}

	@Test
	public void test_save_list_update() {
		System.out.println(gradeService);

		// Create a Grade
		Grade newGrade = new Grade();
		newGrade.setCode("G1");
		newGrade.setNbHeuresBase(new BigDecimal("0.10"));
		newGrade.setTauxBase(new BigDecimal("0.10"));
		gradeService.save(newGrade);
		
		// List all Grades
		List<Grade> grades = gradeService.list();
		assertTrue(grades.contains(newGrade));
		assertTrue(!grades.isEmpty());
		assertEquals(1, gradeService.list().size());

		// Update a Grade
		if (!grades.isEmpty()) {
			Grade gradeToUpdate = grades.get(0);
			gradeToUpdate.setCode("G1");
			gradeToUpdate.setNbHeuresBase(new BigDecimal("0.20"));
			gradeToUpdate.setTauxBase(new BigDecimal("0.30"));
			int rows = gradeService.update(gradeToUpdate);
			assertEquals(1, rows);
			
			grades = gradeService.list();
			assertTrue(gradeToUpdate.equals(grades.get(0)));
			assertEquals(gradeToUpdate, grades.get(0));
		}
	}
}
