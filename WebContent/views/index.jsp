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
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li><a href="?view=game/lista">Início</a>
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Midias<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Mídias</li>
									<li><a href="#">Pesquisar</a></li>
									<li><a href="#">Cadastrar</a></li>
								</ul></li>
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Plataforma<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Plataforma</li>
									<li><a href="#">Pesquisar</a></li>
									<li><a href="#">Cadastrar</a></li>
								</ul>
							<li>
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Gênero<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Gênero</li>
									<li><a href="#">Pesquisar</a></li>
									<li><a href="#">Cadastrar</a></li>
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
	<script type="text/javascript" src="../assets/js/bootstrap.js"></script>
	<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../assets/js/dropdown-bootstrap.js"></script>
</body>
</html>