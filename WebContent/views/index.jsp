<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
	<title>Controle de Games</title>
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css"/>
	

	<script src="../assets/js/jquery-1.7.1.min.js"></script>
	<script src="../assets/js/bootstrap.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="masthead">
			<h3 class="muted">Projeto Java - Games</h3>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Games<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Games</li>
									<li><a href="?view=game/lista">Listar</a></li>
									<li><a href="?view=game/pesquisa">Pesquisar</a></li>
									<li><a href="?view=game/cadastro">Cadastrar</a></li>
								</ul></li>
							
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Midias<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Mídias</li>
									<li><a href="?view=midia/lista">Listar</a></li>
									<li><a href="?view=midia/pesquisa">Pesquisar</a></li>
									<li><a href="?view=midia/cadastro">Cadastrar</a></li>
								</ul></li>
							
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Plataforma<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Plataforma</li>
									<li><a href="?view=plataforma/lista">Listar</a></li>
									<li><a href="?view=plataforma/pesquisa">Pesquisar</a></li>
									<li><a href="?view=plataforma/cadastro">Cadastrar</a></li>
								</ul>
							<li>
							
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Gênero<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Gênero</li>
									<li><a href="?view=genero/lista">Listar</a></li>
									<li><a href="?view=genero/pesquisa">Pesquisar</a></li>
									<li><a href="?view=genero/cadastro">Cadastrar</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	
		<div class="row-fluid">
			<!--Carregamento de conteudo dinamico-->
			<%
				String urlString = request.getParameter("view");
			%>
			<jsp:useBean id="url" class="controllers.ViewController"></jsp:useBean>
			<jsp:setProperty property="view" name="url" value="<%=urlString%>" />
			<jsp:include page="<%=url.content()%>" flush="true"></jsp:include>
			<!-- fim de carregamento dinamico -->
		</div>
		
		<div class="footer">
			<p>&copy; Company 2013</p>
		</div>
	</div>
	

</body>
</html>
