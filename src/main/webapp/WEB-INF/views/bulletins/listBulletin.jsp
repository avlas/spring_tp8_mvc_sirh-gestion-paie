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
		<h1>List des bulletins</h1>
		
		<table style="width:100%">
			  <tr>
				    <th>Id</th>
				    <th>Periode</th> 
				    <th>Matricule</th> 
				    <th>Salaire brut</th>
				    <th>Net imposable</th>
				    <th>Net a payer</th>
				    <th>Actions</th>
			  </tr>
		  <c:forEach var = "bulletinSalaire" items = "${bulletinSalaires}">
			  <tr>
				    <td>${bulletinSalaire.id}</td>
				    <td>${bulletinSalaire.periode.dateDebut}-${bulletinSalaire.periode.dateFin}</td> 
				    <td>${bulletinSalaire.remunerationEmploye.matricule}</td> 
				    
				    <td>${bulletinSalaire.resultatCalculRemuneration.salaireBrut}</td> 
				    <td>${bulletinSalaire.resultatCalculRemuneration.netImposable}</td> 
				    <td>${bulletinSalaire.resultatCalculRemuneration.netAPayer}</td> 
				    <td><button type="submit">Visualiser</button></td> 
			  </tr>
		  </c:forEach>
		</table>
			
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</body>
</html>


