<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registro de equipo</title>
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
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${team != null }">
					<form action="updateTeam" method="post">
				</c:if>	
				<c:if test="${team == null }">
					<form action="newTeam" method="post">
				</c:if>	
				
				<caption>
					<h2>
						<c:if test="${team != null}">
							Editar Equipo
						</c:if>
						<c:if test="${team == null}">
							Agregar Nuevo Equipo
						</c:if>
					</h2>
				</caption>
				
				<c:if test="${team != null}">
					<input type="hidden" name="id" value="<c:out value='${team.id}'/>"/>
				</c:if>
				
				<fieldset class="form-group">
					<label>Código del Equipo</label> <input type="text" value="<c:out value='${team.id}'/>" class="form-control" name="id" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre del Equipo</label> <input type="text" value="<c:out value='${team.name}'/>" class="form-control" name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Pais del equipo</label> <input type="text" value="<c:out value='${team.getCountry().getName()}'/>" class="form-control" name="country" >
				</fieldset>
				
				<button type="submit" class="btn btn-success">Guardar</button>
				
			</div>
		</div>
	</div>
	

</body>
</html>