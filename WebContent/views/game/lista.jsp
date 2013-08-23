<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Games</title>

	<title>Drop Down Navbar</title>
	<link rel="stylesheet" type="text/css" href="../../assets/css/bootstrap.css"/>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="../../assets/js/bootstrap.js"></script>
</head>

  <body>    
    <script src="../../assets/js/bootstrap.js"></script>
    <script src="../../assets/js/bootstrap.min.js"></script>
	
	<jsp:useBean id="controller" class="controllers.GameController"></jsp:useBean>
 	
 	
 	<div style="width: 1000px">
		<table class="table table-striped">
			<tr align="left">
				<th bgcolor="#e0e0e0">Cód</th>
				<th bgcolor="#e0e0e0">Nome</th>
				<th bgcolor="#e0e0e0">Descrição</th>
				<!-- th bgcolor="#e0e0e0">Data Nascimento</th-->
				<th bgcolor="#e0e0e0">Capa</th>
				<th bgcolor="#e0e0e0">Genero</th>
				<th bgcolor="#e0e0e0">Plataforma</th>
				<th bgcolor="#e0e0e0">Midia</th>
			</tr>
			<c:forEach var="game" items="${controller.gameLista()}" varStatus="i">
				<c:choose>
					<c:when test="${i.count % 2 == 0}">
						<tr bgColor="#f6f6f6">
					</c:when>
					<c:otherwise>
						<tr bgColor="#affffb">
					</c:otherwise>
				</c:choose>
				<td title="Cód">${game.game_id}</td>
				<td title="Nome">${game.game_nome}</td>
				<td title="Descrição">${game.game_descricao}</td>
				<td title="Capa">${game.game_capa}</td>
				<td title="Genero">${game.gen_id}</td>
				<td title="Plataforma">${game.pla_id}</td>
				<td title="Midia">${game.mid_id}</td>


			</c:forEach>
		</table>
	</div>
   </body>
</html>