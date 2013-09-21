<%@page import="model.beans.PlataformaBean"%>
<jsp:useBean class="controllers.PlataformaController" id="plataformaController"></jsp:useBean>
<% int pla_id = Integer.parseInt(request.getParameter("pla_id"));  %>
<jsp:setProperty property="pla_id" name="plataformaController" value="<%=pla_id%>"/>
<% PlataformaBean plataformaBean = plataformaController.plataformaPorId(); %>

<div class="well span4">
	<div align="center"><fieldset>Edição Plataformas</fieldset></div>
	<br>
	<form action="/javap1/PlataformaServlet" method="get">
		<div class="control-group">
			<label class="control-label">Código:</label>
			<div class="controls">
				<input type="text" name="pla_id" value="<%=(plataformaBean.getPla_id() == null) ? "" : plataformaBean.getPla_id() %>" readonly	placeholder="Código" /><br />
			</div>
			
			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="pla_nome" value="<%=(plataformaBean.getPla_nome() == null) ? "" : plataformaBean.getPla_nome()%>"	placeholder="Nome" />
			</div>
			
			<label class="control-label">Descrição:</label>
			<div class="controls">
				<input type="text" name="pla_descricao"	value="<%=(plataformaBean.getPla_descricao() == null) ? "" : plataformaBean.getPla_descricao()  %>" placeholder="Descrição" /><br />
			</div>
		</div>
		
		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
		</div>
	</form>
</div>