<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<link rel="stylesheet" href="../../assets/css/bootstrap.css">
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css" />

<div class="well span4">
	<div align="center"><fieldset>Cadastro Midia</fieldset></div>
	<br>
	<form action="MidiaServlet" method="POST">
		<div class="control-group">
			<label class="control-label">Código:</label>
			<div class="controls">
				<input type="text" name="id" value="${param.id}" readonly
					placeholder="Código" /><br />
			</div>
			
			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="nome" value="${requestScope.nome}"
					placeholder="Nome" />
			</div>
		</div>
		
		
		<!-- input type="hidden" name="logica" value="AddUpdateContatoLogic" /--> 
		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-large btn-primary"/></div> 
		
		<div align="right">
			<a href="../views/index.jsp"><input type="button" value="Voltar"	class="btn btn-large btn-primary" /></a>
		</div>
	</form>
</div>