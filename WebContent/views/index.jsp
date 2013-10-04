<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
	<title>Controle de Games</title>
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="../assets/css/icons-desktop.css"/>
<!-- 	<link rel="stylesheet" type="text/css" href="../assets/css/datepicker.css"/> -->

	<script src="../assets/js/jquery-1.7.1.min.js"></script>
<!-- 	<script src="../assets/js/jquery-ui-1.8.2.custom.min.js"></script> -->
	<script src="../assets/js/bootstrap.js"></script>
<!-- 	<script src="../assets/js/datepicker/bootstrap-datepicker.min.js"></script> -->

		<link type="text/css" href="../assets/css/jquery-ui-1.10.3.custom.css" rel="stylesheet" />
		<link type="text/css" href="../assets/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet" />
		<script type="text/javascript" src="../assets/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../assets/js/jquery-ui-1.10.3.custom.js"></script>
		<script type="text/javascript" src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>

	<script src="../assets/js/utils.js"></script>
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
									<li><a href="?view=game/game-lista">Listar</a></li>
									<li><a href="?view=game/game-cadastro">Cadastrar</a></li>

								</ul>
							</li>
							
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Midias<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Mídias</li>
									<li><a href="?view=midia/midia-lista">Listar</a></li>
									<li><a href="?view=midia/midia-cadastro">Cadastrar</a></li>

								</ul>
							</li>
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Plataforma<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Plataforma</li>
									<li><a href="?view=plataforma/plataforma-lista">Listar</a></li>
									<li><a href="?view=plataforma/plataforma-cadastro">Cadastrar</a></li>
								</ul>
							<li>
							
							<li class="dropdown"><a data-toggle="dropdown"
								class="dropdown-toggle" href="#">Gênero<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li class="nav-header">Gênero</li>
									<li><a href="?view=genero/genero-lista">Listar</a></li>
									<li><a href="?view=genero/genero-cadastro">Cadastrar</a></li>
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

		<br>
		<div class="footer">
			<p>&copy; Company 2013</p>
		</div>
	</div>
	

</body>
</html>
