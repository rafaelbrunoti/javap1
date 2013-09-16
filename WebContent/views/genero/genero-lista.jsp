<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controllers.PlataformaController" %>

<legend>Lista de Gênero</legend>
<div>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Cód</th>
				<th>Gênero</th>
				<th>Descrição</th>
				<th colspan="2" style="text-align: center;">Ações</th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="listaGenero" class="controllers.GeneroController"></jsp:useBean>
			<c:forEach var="listas" items="${listaGenero.generoLista()}">
				<tr>
					<td>${listas.getGen_id()}</td>
					<td>${listas.getGen_nome()}</td>
					<td>${listas.getGen_descricao()}</td>  		
					<td><a class="btn btn btn-mini btn-primary " href="?view=genero/genero-editar&gen_id=${listas.getGen_id()}" rel="tooltip" data-placement="top" title="Editar Registro"><i class="icon-edit icon-white"></i></a></td>
					<td><a class="btn btn btn-mini btn-danger " href="/javap1/GeneroServlet?gen_id=${listas.getGen_id()}&acao=delete" rel="tooltip" data-placement="top" title="Excluir Registro"><i class="icon-remove-sign icon-white"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="span10">
	<a class="btn btn-success" href="index.jsp">Voltar</a>
</div>
