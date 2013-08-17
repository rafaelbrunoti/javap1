<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="well span4">
	<fieldset>Gêneros</fieldset>
	<form action="GeneroServlet" method="POST">
		<div class="control-group">
			<label class="control-label" for="inputEmail">Código:</label>
			<div class="controls">
				<input type="text" name="id" value="${param.id}" readonly
					placeholder="Código" /><br />
			</div>
			<div class="controls">
				<input type="text" name="nome" value="${requestScope.nome}"
					placeholder="Nome" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputEmail">Descrição:</label>
			<div class="controls">
				<input type="text" name="descricao"
					value="${requestScope.descricao}" placeholder="Descrição" /><br />
			</div>
		</div>

		<input type="hidden" name="logica" value="AddUpdateContatoLogic" /> <input
			type="submit" value="Enviar" class="btn btn-large btn-primary" /> <a
			href="lista-contato.jsp"> <input type="button" value="Voltar"
			class="btn btn-large btn-primary" />
		</a>
	</form>
</div>
