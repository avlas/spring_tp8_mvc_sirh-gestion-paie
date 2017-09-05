package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

public interface GradeService {
	
//	void createTable();
	
	void truncateTable();
	
	void save(Grade newGrade);

	List<Grade> list();
	
	int update(Grade grade);
}
