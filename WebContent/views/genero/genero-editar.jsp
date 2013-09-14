<%@page import="model.beans.GeneroBean"%>
<jsp:useBean class="controllers.GeneroController" id="generoController"></jsp:useBean>
<% int id = Integer.parseInt(request.getParameter("id"));  %>
<jsp:setProperty property="gen_id" name="generoController" value="<%=id%>"/>
<% GeneroBean generoBean = generoController.generoPorId(); %>

<div class="well span4">
	<div align="center"><fieldset>Cadastro Gêneros</fieldset></div>
	<br>
	<form action="/javap1/GeneroServlet" method="get">
		<div class="control-group">
			<label class="control-label">Código:</label>
			<div class="controls">
				<input type="text" name="id" value="<%=(generoBean.getGen_id() == null) ? "" : generoBean.getGen_id() %>" readonly	placeholder="Código" /><br />
			</div>
			
			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="nome" value="<%=(generoBean.getGen_nome() == null) ? "" : generoBean.getGen_nome()%>"	placeholder="Nome" />
			</div>
			
			<label class="control-label">Descrição:</label>
			<div class="controls">
				<input type="text" name="descricao"	value="<%=(generoBean.getGen_descricao() == null) ? "" : generoBean.getGen_descricao()  %>" placeholder="Descrição" /><br />
			</div>
		</div>
		
		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
		</div>
	</form>
</div>