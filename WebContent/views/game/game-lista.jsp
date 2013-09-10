<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="controllers.PlataformaController"%>

<legend>Lista de Games</legend>
<div>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Cód</th>
				<th>Nome</th>
				<!--th>Data do Game</th-->
				<th>Descrição</th>
				<th>Capa</th>
				<th>Genero</th>
				<th>Plataforma</th>
				<th>Midia</th>
				<th colspan="2" style="text-align: center;">Ações</th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="listaGame" class="controllers.GameController"></jsp:useBean>
			<c:forEach var="listas" items="${listaGame.gameLista()}">
				<tr>
					<td>${listas.getGame_id()}</td>
					<td>${listas.getGame_nome()}</td>
					<!--td>${listas.getGame_data()}</td-->
					<td>${listas.getGame_descricao()}</td>
					<td><a href=${listas.getGame_capa()}>Visualizar</a></td>
					<td>${listas.getGen_id()}</td>
					<td>${listas.getMid_id()}</td>
					<td>${listas.getPla_id()}</td>
					<td><a class="btn btn btn-mini btn-primary " href="?views=game/game-cadastro" rel="tooltip" data-placement="top" title="Editar Registro"><i class="icon-edit"></i></a></td>
					<td><a class="btn btn btn-mini btn-danger " href="?views=game/game-cadastro" rel="tooltip" data-placement="top" title="Excluir Registro"><i class="icon-remove-sign"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="span10">
	<a class="btn btn-success" href="index.jsp">Voltar</a>
</div>
