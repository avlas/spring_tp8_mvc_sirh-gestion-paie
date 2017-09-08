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
	
		<h1>Ajouter un employe</h1>
		
		<form method="post" action="http://localhost:8080/paie/mvc/employes/create">
			Matricule : 
				<input type="text" name="matricule">		
			</br> 
			
			Entreprise :
				<select name="entrepriseId"> <!--  -->
					<option>Selectioner une entreprise</option>
					<c:forEach var = "entreprise" items = "${entreprises}">
						<option value="${entreprise.id}">${entreprise.denomination}</option>
				    </c:forEach>
				</select>		
			</br> 
			
			Profil :
				<select name="profilId">
					<option>Selectioner un profil</option>
					<c:forEach var = "profil" items = "${profils}">
						<option value="${profil.id}">${profil.code}</option>
				    </c:forEach>
				</select>	
			</br> 
			
			Grade :
				<select name="gradeId">
					<option>Selectioner un grade</option>
					<c:forEach var = "grade" items = "${grades}">
						<option value="${grade.id}">${grade.code}</option>
				    </c:forEach>
				</select>	
			</br>

			<button type="submit">Ajouter</button>
			
		</form>
	
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</body>
</html>


