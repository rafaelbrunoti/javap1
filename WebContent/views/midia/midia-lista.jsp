<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="controllers.MidiaController"%>

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
					<td><a class="btn btn btn-mini btn-primary " href="?view=midia/midia-editar&mid_id=${listas.getMid_id()}" rel="tooltip" data-placement="top" title="Editar Registro"><i class="icon-edit icon-white"></i></a></td>
					<td><a class="btn btn btn-mini btn-danger " href="/javap1/MidiaServlet?mid_id=${listas.getMid_id()}&acao=delete" rel="tooltip" data-placement="top" title="Excluir Registro"><i class="icon-remove-sign icon-white"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="span10">
	<a class="btn btn-success" href="index.jsp">Voltar</a>
</div>

