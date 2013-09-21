<%@page import="model.beans.MidiaBean"%>
<jsp:useBean class="controllers.MidiaController" id="midiaController"></jsp:useBean>
<% int mid_id = Integer.parseInt(request.getParameter("mid_id"));  %>
<jsp:setProperty property="mid_id" name="midiaController" value="<%=mid_id%>"/>
<% MidiaBean midiaBean = midiaController.midiaPorId(); %>

<div class="well span4">
	<div align="center"><fieldset>Edição Midia</fieldset></div>
	<br>
	<form action="/javap1/MidiaServlet" method="get">
		<div class="control-group">
			<label class="control-label">Código:</label>
			<div class="controls">
				<input type="text" name="mid_id" value="<%=(midiaBean.getMid_id() == null) ? "" : midiaBean.getMid_id() %>" readonly	placeholder="Código" /><br />
			</div>
			
			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="mid_nome" value="<%=(midiaBean.getMid_nome() == null) ? "" : midiaBean.getMid_nome()%>"	placeholder="Nome" />
			</div>

		</div>
		
		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
		</div>
	</form>
</div>