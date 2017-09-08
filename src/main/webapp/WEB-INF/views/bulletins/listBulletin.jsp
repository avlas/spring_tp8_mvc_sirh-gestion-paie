<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../../../header.jsp"%>

<p class="h4 text-center">Liste des bulletins</p>
</br>

<a class="btn btn-secondary btn-sm" style="float: center; margin-left: 100px" 
	href="http://localhost:8080/paie/mvc/bulletins/create" role="button">Ajouter un bulletin</a>
</br>

<div class="container">
	<div class="row">
		<div class="col-sm-6 offset-sm-3">
			<table class="table table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>Id</th>
						<th>Periode</th>
						<th>Matricule</th>
						<th>Salaire brut</th>
						<th>Net imposable</th>
						<th>Net a payer</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="bulletinSalaire" items="${bulletinSalaires}">
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
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@include file="../../../footer.jsp"%>