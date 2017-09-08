<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../../../header.jsp"%>

	<p class="h4 text-center">Liste des employes</p>
	</br>
	
	<a class="btn btn-secondary btn-sm" style="float: center; margin-left: 100px"
		href="http://localhost:8080/paie/mvc/employes/create" role="button">Ajouter un employe</a>
	</br>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 offset-sm-3">
				<table class="table table-hover">
					<thead class="thead-inverse">
						<tr>
							<th>Id</th>
							<th>Matricule</th>
							<th>Grade</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="employe" items="${employes}">
							<tr>
								<td>${employe.id}</td>
								<td>${employe.matricule}</td>
								<td>${employe.grade.code}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

<%@include file="../../../footer.jsp"%>


