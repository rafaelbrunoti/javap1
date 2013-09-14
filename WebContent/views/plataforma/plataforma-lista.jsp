<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="controllers.PlataformaController"%>

<legend>Lista de Plataforma</legend>
<div>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome da Plataforma</th>
				<th>Descrição da Plataforma</th>
				<th colspan="2" style="text-align: center;">Ações</th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="listaPlataforma"
				class="controllers.PlataformaController"></jsp:useBean>
			<c:forEach var="listas" items="${listaPlataforma.plataformaLista()}">
				<tr>
					<td>${listas.getPla_id()}</td>
					<td>${listas.getPla_nome()}</td>
					<td>${listas.getPla_descricao()}</td>
					<td><a class="btn btn btn-mini btn-primary " href="?views=game/game-cadastro" rel="tooltip" data-placement="top" title="Editar Registro"><i class="icon-edit icon-white"></i></a></td>
					<td><a class="btn btn btn-mini btn-danger " href="?views=game/game-cadastro" rel="tooltip" data-placement="top" title="Excluir Registro"><i class="icon-remove-sign icon-white"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="span10">
	<a class="btn btn-success" href="index.jsp">Voltar</a>
</div>
