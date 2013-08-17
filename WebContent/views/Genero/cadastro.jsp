<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="well span4">
	<fieldset>G�neros</fieldset>
	<form action="GeneroServlet" method="POST">
		<div class="control-group">
			<label class="control-label" for="inputEmail">C�digo:</label>
			<div class="controls">
				<input type="text" name="id" value="${param.id}" readonly
					placeholder="C�digo" /><br />
			</div>
			<div class="controls">
				<input type="text" name="nome" value="${requestScope.nome}"
					placeholder="Nome" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputEmail">Descri��o:</label>
			<div class="controls">
				<input type="text" name="descricao"
					value="${requestScope.descricao}" placeholder="Descri��o" /><br />
			</div>
		</div>

		<input type="hidden" name="logica" value="AddUpdateContatoLogic" /> <input
			type="submit" value="Enviar" class="btn btn-large btn-primary" /> <a
			href="lista-contato.jsp"> <input type="button" value="Voltar"
			class="btn btn-large btn-primary" />
		</a>
	</form>
</div>
