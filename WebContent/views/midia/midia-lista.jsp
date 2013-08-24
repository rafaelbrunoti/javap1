<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controllers.MidiaController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../../assets/css/bootstrap.css">
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css" />
<script type="text/javascript" src="../../assets/js/bootstrap.js"></script>
<script type="text/javascript" src="../../assets/js/bootstrap.min.js"></script>
<title>Gerenciamento da Game</title>
</head>
<body>
	<legend>Lista de Midias</legend>
	<div class="span5">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome da Midia</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
			<jsp:useBean id="listaMidia" class="controllers.MidiaController"></jsp:useBean>
			<c:forEach var="listas" items="${listaMidia.midiaLista()}">
				<tr>
					<td>${listas.getMid_id()}</td>
					<td>${listas.getMid_nome()}</td>
					<td>Editar</td>
					<td>Excluir</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
	</div>
	<div class="span10">
		<a class="btn btn-success" href="../../index.jsp">Voltar</a>
	</div>
</body>
</html>