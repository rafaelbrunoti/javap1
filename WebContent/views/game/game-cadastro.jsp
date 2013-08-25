<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../../assets/css/bootstrap.css">
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css" />

<div class="well span7">
	<div align="center"><fieldset>Cadastro Games</fieldset></div>
	<br>
	<form action="GameServlet" method="POST">
		<div class="control-group">
		<table>
			<tr>
				<td>
				 	<label class="control-label">Código:</label>
					<div class="controls">
						<input type="text" name="id" value="${param.id}" readonly
							placeholder="Código" /><br />
					</div>
				
					<label class="control-label">Nome:</label>
					<div class="controls">
						<input type="text" name="nome" value="${requestScope.nome}"
							placeholder="Nome" />
					</div>
					
					<label class="control-label">Data:</label>
					<div class="controls">
						<input type="text" name="data" maxlength="10" value="${requestScope.data}"
							placeholder="Data" />
					</div>
				
					<label class="control-label">Descrição:</label>
					<div class="controls">
						<input type="text" name="descricao"
							value="${requestScope.descricao}" placeholder="Descrição" /><br />
					</div>
					
				</td>
				<td style="width:54px;"></td>
				<td>
					<label class="control-label">Capa:</label>
					<select>
						<option>Selecione..</option>
					</select>
					<label class="control-label">Genero:</label>
					<select>
						<option>Selecione..</option>
					</select>
					<label class="control-label">Midia:</label>
					<select>
						<option>Selecione..</option>
					</select>	
					<label class="control-label">Plataforma:</label>
					<select>
						<option>Selecione..</option>
					</select>
				</td>
			</tr>
			</table>
		</div>
		
		
		<!-- input type="hidden" name="logica" value="AddUpdateContatoLogic" /--> 
		<div style=" float: left; width: 220px; height: 45px; border:solid 0px;">
			<div align="right">	
				<input type="submit" value="Enviar" class="btn btn-large btn-primary"/>
			</div>
		</div> 
		
		<div style=" float: right; width: 220px; height: 45px; border: solid 0px;">			<!-- <div align="right" style="border:solid 1px;">  -->
			<div align="left">
				<a href="../views/index.jsp">
					<input type="button" value="Voltar" class="btn btn-large btn-primary" />
				</a>
			</div>
		</div>
	</form>
</div>