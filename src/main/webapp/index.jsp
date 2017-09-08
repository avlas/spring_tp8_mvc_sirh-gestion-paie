<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
		<title>PAIE</title>
	</head>
	<body> 
		<h1>SIRH - Gestion de la paie</h1>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
		
		<!-- a href= "http://localhost:8080/paie/mvc/employes/create">Create Employe</a-->
		</br> 
		<a href= "<%=request.getContextPath() %>/mvc/employes/create">Create Employe</a>	
		
		</br> 	
		<a href= "<%=request.getContextPath() %>/mvc/employes/list">List Employe</a>	
		
		</br> 	
		<a href= "<%=request.getContextPath() %>/mvc/bulletins/create">Create Bulletin</a>
		
		</br> 
		<a href= "<%=request.getContextPath() %>/mvc/bulletins/list">List Bulletins</a>	
		
		</br> 
		<a href= "<%=request.getContextPath() %>/mvc/bulletins/visualise">Visualiser Bulletin</a>	
	</body>
</html>