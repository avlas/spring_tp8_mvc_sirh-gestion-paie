<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
		<title>PAIE</title>
	</head>
	
	<body>
	
		<h1>Creer bulletin de salaire</h1>
		
		<form method="post" action="http://localhost:8080/paie/mvc/bulletins/create">
			Periode :
				<select name="periodeId"> <!--  -->
					<option>Selectioner une periode</option>
					<c:forEach var = "periode" items = "${periodes}">
						<option value="${periode.id}">${periode.dateDebut}-${periode.dateFin}</option>
				    </c:forEach>
				</select>		
			</br> 
			
			Matricule :
				<select name="matriculeId">
					<option>Selectioner un matricule</option>
					<c:forEach var = "matricule" items = "${matricules}">
						<option value="${matricule}">${matricule}</option>
				    </c:forEach>
				</select>	
			</br> 
			
			Prime exceptionnelle : 
				<input type="text" name="prime">		
			</br> 

			<button type="submit">Ajouter</button>
			
		</form>
	
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</body>
</html>


