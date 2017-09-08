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
		<h1>List des employes</h1>
		
		<table style="width:100%">
			  <tr>
				    <th>Id</th>
				    <th>Matricule</th> 
				    <th>Grade</th>
			  </tr>
		  <c:forEach var = "employe" items = "${employes}">
			  <tr>
				    <td>${employe.id}</td>
				    <td>${employe.matricule}</td> 
				    <td>${employe.grade.code}</td> 
			  </tr>
		  </c:forEach>
		</table>
			
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</body>
</html>


