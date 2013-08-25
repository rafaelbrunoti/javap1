<div class="well span4">
	<div align="center"><fieldset>Cadastro Gêneros</fieldset></div>
	<br>
	<form action="/javap1/GeneroServlet" method="get">
		<div class="control-group">
			<label class="control-label">Código:</label>
			<div class="controls">
				<input type="text" name="id" value="" readonly	placeholder="Código" /><br />
			</div>
			
			<label class="control-label">Nome:</label>
			<div class="controls">
				<input type="text" name="nome" value=""	placeholder="Nome" />
			</div>
			
			<label class="control-label">Descrição:</label>
			<div class="controls">
				<input type="text" name="descricao"	value="" placeholder="Descrição" /><br />
			</div>
		</div>
		
		<div style=" float: left;"><input type="submit" value="Enviar" class="btn btn-primary"/></div> 
		
		<div align="right">
<<<<<<< HEAD
			<a class="btn btn-primary" href="index.jsp">Voltar</a>
=======
			<a href="../views/index.jsp"><input type="button" value="Voltar"	class="btn btn-large btn-primary" /></a>
>>>>>>> 30620ba855c6e00e23cae1fa1ad28d4aca16913a
		</div>
	</form>
</div>