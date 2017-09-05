package dev.paie.service;

import static org.junit.Assert.assertEquals;
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
	
	@Autowired
	Grade grade1;

	@Before
	public void setup() {
		gradeService.truncateTable();
	}

	@Test
	public void test_save_list_update() {
		System.out.println(gradeService);

		// Create a Grade 
//		Grade grade = new Grade();
//		grade.setCode("G1");
//		grade.setNbHeuresBase(new BigDecimal("0.10"));
//		grade.setTauxBase(new BigDecimal("0.10"));
//		gradeService.save(grade);		

		// Use the bean "grade1", avec les valeurs qui sont dans jdd-config.xml
		gradeService.save(grade1);									
		System.out.println("AVANT = " + grade1.toString());
		
		// List all Grades
		List<Grade> grades = gradeService.list();
		System.out.println("APRES = " + grades.get(0).toString());
		
		assertTrue(grades.contains(grade1));
		assertTrue(!grades.isEmpty());
		assertEquals(1, gradeService.list().size());

		// Update a Grade
		if (!grades.isEmpty()) {
			grade1 = grades.get(0);
			grade1.setCode("G1");
			grade1.setNbHeuresBase(new BigDecimal("0.20"));
			grade1.setTauxBase(new BigDecimal("0.30"));
			int rows = gradeService.update(grade1);
			assertEquals(1, rows);
			
			grades = gradeService.list();
			assertTrue(grade1.equals(grades.get(0)));
			assertEquals(grade1, grades.get(0));
		}
	}
}
