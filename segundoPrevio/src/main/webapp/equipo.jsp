<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Equipos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
</head>
<body>

	<header>
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-expand-md navbar-dark"
					style="background-color: blue">
					<div>
						<a href="#" class="navbar-brand">Equipos</a>
					</div>
					<ul class="navbar-nav">
						<li><a href="<%=request.getContextPath()%>/" class="nav-link">home</a></li>
					</ul>
				</nav>

			</div>
		</div>
	</header>

	<div class="container">
		<div class="row">
		<a href="<%= request.getContextPath()%>/newTeam" class="btn btn-success">Agregar Nuevo Equipo</a>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Pais</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${teams}">
						<tr>
							<td><c:out value="${i.id}" /></td>
							<td><c:out value="${i.name}" /></td>
							<td><c:out value="${i.getCountry().getName()}" /></td>
							<td><a
								href="<%=request.getContextPath()%>/edit?id=<c:out value='${i.id}'/>">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/delete?id=<c:out value='${i.id}'/>">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>


	</div>

</body>
</html>