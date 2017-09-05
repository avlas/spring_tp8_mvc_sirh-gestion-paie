CREATE DATABASE IF NOT EXISTS `spring-jdbc-sirh-paie`;

USE `spring-jdbc-sirh-paie`;

CREATE TABLE IF NOT EXISTS Grade(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
													gradeCode VARCHAR(100), 
													nbHeuresBase DECIMAL(10,2), 
													tauxBase DECIMAL(10,2)
								);
                                
DROP DATABASE `spring-jdbc-sirh-paie`;