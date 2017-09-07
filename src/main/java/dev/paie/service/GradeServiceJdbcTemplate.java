package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entity.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	@Autowired
	DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Grade newGrade) {	
		String sql= "INSERT INTO grade (code, nbHeuresBase, tauxBase) VALUES (?, ?, ?)";

		this.jdbcTemplate.update(sql, newGrade.getCode(), newGrade.getNbHeuresBase(), newGrade.getTauxBase());
	}

	@Override
	public List<Grade> list() {
		String sql= "SELECT * FROM grade";
		Grade mappedGrade = this.jdbcTemplate.queryForObject(sql, new GradeMapper());
		
		List<Grade> grades = new ArrayList<Grade>();
		if(mappedGrade != null) {
			grades.add(mappedGrade);
		}
		return grades;
	}
	
	@Override
	public int update(Grade grade) {
		String sql= "UPDATE grade SET code=?, nbHeuresBase=?, tauxBase=? WHERE id=?";
		return this.jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());		
	}
	
//	@Override
//	public void createTable() {
//		String sql= "CREATE TABLE IF NOT EXISTS Grade(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, code VARCHAR(100), nbHeuresBase DECIMAL(10,2), tauxBase DECIMAL(10,2) );";
//		this.jdbcTemplate.execute(sql);
//	}

	@Override
	public void truncateTable() {
		
//		String sqlTableExistence = "SELECT table_name FROM information_schema.tables WHERE table_schema = \'spring-jdbc-sirh-paie\' AND table_name = \'grade\' ";
//		this.jdbcTemplate.execute(sqlTableExistence);
				
		//String sql= "TRUNCATE TABLE IF EXISTS grade";
		
//		String sql= "TRUNCATE TABLE IF EXISTS grade";
//		this.jdbcTemplate.update(sql);
	}
}
