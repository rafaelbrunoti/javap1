<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controllers.GeneroController" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../../assets/css/bootstrap.css">
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css" />
<script type="text/javascript" src="../../assets/js/bootstrap.js"></script>
<script type="text/javascript" src="../../assets/js/bootstrap.min.js"></script>
<title>Gerenciamento de Games</title>
</head>
<body>
<legend>Lista de Generos</legend>
	<div class="span8">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome do Genero</th>
					<th>Descrição do Genero</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<jsp:useBean id="listaGenero" class="controllers.GeneroController"></jsp:useBean>
			<c:forEach var="listas" items="${listaGenero.generoLista()}">
			<tbody>
				<tr>
					<td>${listas.getGen_id()}</td>
					<td>${listas.getGen_nome()}</td>
					<td>${listas.setGen_descricao()}</td>
					<td>Editar</td>
					<td>Excluir</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="span10">
			<a class="btn btn-success" href="index.jsp">Voltar</a>
	</div>	
</body>
</html>