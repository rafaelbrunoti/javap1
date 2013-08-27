<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<link rel="stylesheet" href="../../assets/css/bootstrap.css">
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css" />

<!-- Inicio do primeiro formulário -->

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

<!-- Fim do primeiro formulário -->


<!-- Inicio do Segundo formulário -> de acordo com o nosso amigo que nunca erra e sempre faz cagada 27/08/13 16:20  -->

<div class="well span7">
	<div style="font-size:16px; font-weight: bold; color: #27408B; text-align: center;">
		<fieldset>Cadastro Games</fieldset>
	</div>
	<br>
	<form action="GameServlet" method="POST">
		<div class="control-group">
			<div style="border: solid 0px red;">
				<table>
					<tr style="border: solid 0px;">
						<td style="vertical-align: top; padding: 10px;">
						
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
							<label class="control-label">Genero:</label>
							<select>
								<option>Selecione..</option>
							</select>
							<br>	
						</td>
						
						<td style="width: 40px;"></td>
						
						<td style="vertical-align: top; padding: 10px;">
							<table>
								<tr>
									<td style="border solid: 1px;">
										<div style="border: solid 1px #27408B; display: table-cell; vertical-align: middle; text-align:center; width: 160px; height: 90px; -moz-border-radius: 5px; -webkit-border-radius: 5px; border-radius: 5px; padding:10px;" align="center">
											<img src="" id=""  class="myicon_big" style="-moz-border-radius: 2px; -webkit-border-radius: 2px; border-radius: 2px;">
										</div>
									</td>
								</tr>
								<tr style="height: 13px; border: solid 0px;"></tr>
							</table>
							
							<table>
								<tr>
									<td>
										<div>
											<label class="control-label">Midia:</label>
											<select>
												<option>Selecione..</option>
											</select>
										</div>
										<div>
											<label class="control-label">Plataforma:</label>
											<select>
												<option>Selecione..</option>
											</select>
										</div>	
									</td>
								</tr>
							</table>
						</td>	
					</tr>
				</table>
				<table>
					<tr style=" border: solid 0px;">
						<td>
							<div class="controls" style="width:522px;  height:100px; border: solid 0px;">
								<label class="control-label">Descrição:</label>
								<textarea rows="3" cols="5" style="width:500px;  height:50px; border: solid 1px #27408B;" placeholder="Descrição"></textarea>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
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

<!-- fim do segundo formulário -->