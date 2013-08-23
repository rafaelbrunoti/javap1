<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controllers.GameController" %>   
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
<legend>Lista de Games</legend>
<div class="span10">	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Cód</th>
				<th>Nome</th>
			<!--<th>Data do Game</th>-->
				<th>Descrição</th>
				<th>Capa</th>
				<th>Genero</th>
				<th>Plataforma</th>
				<th>Midia</th>
				<th colspan="2">Ações</th>
			</tr>	
		</thead>
	 	<jsp:useBean id="listaGame" class="controllers.GameController"></jsp:useBean>
		<c:forEach var="listas" items="${listaGame.gameLista()}">  
		<tbody>	
			<tr>
				<td>${listas.getGame_id()}</td>
				<td>${listas.getGame_nome()}</td>
		<!-- 	<td>${listas.getGame_data()}</td>  -->
				<td>${listas.getGame_descricao()}</td>
				<td>${listas.getGame_capa()}</td>
				<td>${listas.getGen_id()}</td>
				<td>${listas.getMid_id()}</td>
				<td>${listas.getPla_id()}</td>
				<td>Editar</td>
				<td>Excluir</td>
			</tr>
		</tbody>
	 	</c:forEach> 
	</table>
</div>	
<div class="span10">
		<a class="btn btn-success" href="index.jsp">Voltar</a>
</div>
</body>
</html>