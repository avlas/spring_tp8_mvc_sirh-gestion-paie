<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<title>SIRH</title>
</head>

<body>
	<h1>SIRH - Gestion de la paie</h1>

	<!-- a href= "http://localhost:8080/paie/mvc/employes/create">Create Employe</a-->

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/mvc/employes/list">Employes</a>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/mvc/bulletins/list">Bulletins</a>
		</div>
	</nav>