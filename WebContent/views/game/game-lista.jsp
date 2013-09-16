<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="controllers.PlataformaController"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<legend>Lista de Games</legend>
<div>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Cód</th>
				<th>Nome</th>
				<th>Lançamento</th>
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
			<jsp:useBean id="listaGenero" class="controllers.GeneroController"></jsp:useBean>
			
			<c:forEach var="listas" items="${listaGame.gameLista()}">
				<tr>
					<td>${listas.getGame_id()}</td>
					<td>${listas.getGame_nome()}</td>
					<td><fmt:formatDate value="${listas.getGame_data().time}" pattern="dd/MM/yyyy" /></td>
					<td>${listas.getGame_descricao()}</td>
					<td><a href="${listas.getGame_capa()}">Visualizar</a></td>
					
					<td>${listas.getGen_nome()}</td>
					<td>${listas.getMid_nome()}</td>
					<td>${listas.getPla_nome()}</td>
					
					<td><a class="btn btn btn-mini btn-primary " href="?view=game/game-editar&game_id=${listas.getGame_id()}" rel="tooltip" data-placement="top" title="Editar Registro"><i class="icon-edit icon-white"></i></a></td>
					<td><a class="btn btn btn-mini btn-danger " href="/javap1/GameServlet?game_id=${listas.getGame_id()}&acao=delete" rel="tooltip" data-placement="top" title="Excluir Registro"><i class="icon-remove-sign icon-white"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="span10">
	<a class="btn btn-primary" href="?view=game/game-cadastro">Novo</a>
	<a class="btn btn-success" href="index.jsp">Voltar</a>
</div>
