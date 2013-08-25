<div class="well span4">
	<div align="center">
		<fieldset>Cadastro Mídia</fieldset>
	</div>
	<br>
	<form action="/javap1/MidiaServlet" method="get">
		<div class="control-group">
			<label class="control-label">Código:</label>
			<div class="controls">
				<input type="text" name="id" value="" readonly placeholder="Código" /><br />
			</div>

			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="nome" value="" placeholder="Nome" />
			</div>
		</div>

		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
		</div>
</div>