<div class="well span4">
	<div align="center">
		<fieldset>Cadastro Plataforma</fieldset>
	</div>
	<br>
	<form action="/javap1/PlataformaServlet" method="get">
		<div class="control-group">
			<label class="control-label">C�digo:</label>
			<div class="controls">
				<input type="text" name="id" value="" readonly placeholder="C�digo" /><br />
			</div>

			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="nome" value="" placeholder="Nome" />
			</div>

			<label class="control-label">Descri��o:</label>
			<div class="controls">
				<input type="text" name="descricao" value="" placeholder="Descri��o" /><br />
			</div>
		</div>

		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
		</div>
	</form>
</div>