<%@page import="model.beans.GeneroBean"%>
<jsp:useBean class="controllers.GeneroController" id="generoController"></jsp:useBean>
<% int gen_id = Integer.parseInt(request.getParameter("gen_id"));  %>
<jsp:setProperty property="gen_id" name="generoController" value="<%=gen_id%>"/>
<% GeneroBean generoBean = generoController.generoPorId(); %>

<div class="well span4">
	<div align="center"><fieldset>Edi��o G�neros</fieldset></div>
	<br>
	<form action="/javap1/GeneroServlet" method="get">
		<div class="control-group">
			<label class="control-label">C�digo:</label>
			<div class="controls">
				<input type="text" name="gen_id" value="<%=(generoBean.getGen_id() == null) ? "" : generoBean.getGen_id() %>" readonly	placeholder="C�digo" /><br />
			</div>
			
			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="gen_nome" value="<%=(generoBean.getGen_nome() == null) ? "" : generoBean.getGen_nome()%>"	placeholder="Nome" />
			</div>
			
			<label class="control-label">Descri��o:</label>
			<div class="controls">
				<input type="text" name="gen_descricao"	value="<%=(generoBean.getGen_descricao() == null) ? "" : generoBean.getGen_descricao()  %>" placeholder="Descri��o" /><br />
			</div>
		</div>
		
		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
		</div>
	</form>
</div>