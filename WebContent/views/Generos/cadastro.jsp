<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agenda de Contatos</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		Formulário para adição de contatos:<br/>
	<div class="well span4">
		<form  action="mvc" method="POST">
			<div class="control-group">
				<label class="control-label" for="inputEmail">Nome:</label>	
				<div class="controls">	
					<input type="text" name="id" value="${param.id}" readonly placeholder="Código"/><br/> 
				</div>
				<div class="controls">	
					<input type="text" name="nome" value="${requestScope.nome}" placeholder="Nome"/>
				</div>
			</div>		
			<div class="control-group">
				<label class="control-label" for="inputEmail">Email:</label>
				<div class="controls">		
					<input type="text" name="email" value="${requestScope.email}" placeholder="Email"/><br/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">Endereço:</label>	
				<div class="controls">	
					<input type="text" name="endereco" value="${requestScope.endereco}" placeholder="Endereço"/><br/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputEmail">Data Nascimento:</label>	
				<div class="controls">	
					<jdiweb:campoData id="dataNascimento"/>
				</div>
			</div>
			
			<input type="hidden" name="logica" value="AddUpdateContatoLogic"/>
			<input type="submit" value="Enviar" class="btn btn-large btn-primary"/>
			<a href="lista-contato.jsp">
   				<input type="button" value="Voltar" class="btn btn-large btn-primary"/>
			</a>
		</form>
	</div>
	<div class="rodape" >
		<c:import url="rodape.jsp" />
	</div>
		
	</body>
</html>