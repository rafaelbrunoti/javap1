<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gerenciamento de Games</title>
</head>
<body>
<legend>Lista de Generos</legend>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome do Genero</th>
				<th>Descri��o do Genero</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<jsp:useBean id="listaGenero" class="controllers.GeneroController"></jsp:useBean>
		<c:forEach var="listas" items="${listaGenero.generoLista()}">
			<tr>
				<td>${listas.getGen_id()}</td>
				<td>${listas.getGen_nome()}</td>
				<td>${listas.setGen_descricao()}</td>
				<td></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<f:view>

</f:view>
</body>
</html>
</jsp:root>