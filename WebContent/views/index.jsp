<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto Java</title>
<link rel="stylesheet" href="../assets/css/bootstrap.css">
<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3 class="muted">Projeto Java</h3>
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container">
						<ul class="nav">
							<li class="dropdown"><a href="?view=inicio">In�cio</a>
								<ul class="dropdown-menu">
									<li class="nav-header">Pesquisar</li>
									<li class="nav-header">Cadastrar</li>
								</ul>
							</li>
							<li class="dropdown"><a href="#">Midias</a>
								<ul class="dropdown-menu">
									<li class="nav-header">Pesquisar</li>
									<li class="nav-header">Cadastrar</li>
								</ul>
							</li>
							<li class="dropdown"><a href="#">Plataforma</a>
								<ul class="dropdown-menu">
									<li class="nav-header">Pesquisar</li>
									<li class="nav-header">Cadastrar</li>
								</ul>
							<li>
							<li class="dropdown"><a href="#">G�nero</a>
								<ul class="dropdown-menu">
									<li class="nav-header">Pesquisar</li>
									<li class="nav-header">Cadastrar</li>								
								</ul>
							</li>
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
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</body>
</html>