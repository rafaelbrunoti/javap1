<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<jsp:useBean class="model.beans.GameBean" id="gameBean"></jsp:useBean>
<jsp:useBean class="controllers.GameController" id="gameController"></jsp:useBean>
<jsp:useBean class="helpers.HelperDate" id="helperDate"></jsp:useBean>

<% int game_id = Integer.parseInt(request.getParameter("game_id"));  %>
<jsp:setProperty property="game_id" name="gameController" value="<%=game_id%>"/>
<%gameBean = gameController.gamePorId(); %>

<script type="text/javascript" src="../assets/js/game.js"></script>

  <style type="text/css">
  	.capa {
    	width: 220px; 
    	height: 150px; 
    	border: 2px; 
    	border-color: black; 
    	border-style:solid;
    	border-radius: 10px;
	}
  </style>

<div class="well span7">
	<div style="font-size:16px; font-weight: bold; color: #27408B; text-align: center;">
		<fieldset>Altera��o Games</fieldset>
	</div>
	<br>
        <form action="/javap1/GameServlet" enctype="multipart/form-data" method="get">  
 		<div class="control-group" style="border: solid 0px red;">
			<div style="border: solid 0px red;">
				<table>
					<tr style="border: solid 0px;">
						<td style="vertical-align: top; padding: 10px; border: solid 0px; height: 100px;">
						
							<label class="control-label">C�digo:</label>
							<div class="controls">
								<input type="text" name="game_id" value="<%=(gameBean.getGame_id() == null) ? "" : gameBean.getGame_id() %>" readonly
									placeholder="C�digo" /><br />
							</div>
							<label class="control-label">Nome:</label>
							<div class="controls">
								<input type="text" name="game_nome" value="<%=(gameBean.getGame_nome() == null) ? "" : gameBean.getGame_nome() %>"
									placeholder="Nome" />
							</div>
							<label class="control-label">Data:</label>
							<div class="controls">
								<input id="calendario" type="text" name="game_data" maxlength="10" value="<%=(gameBean.getGame_data() == null) ? "" : helperDate.getDateToStr(gameBean.getGame_data())  %>"
									placeholder="Data" />
							</div>
							<label class="control-label">Genero:</label>
							<select id="gen_id" name="gen_id">
								<jsp:useBean id="listaGenero" class="controllers.GeneroController"></jsp:useBean>
								<option>Seleciones...</option>
								<c:forEach var="listas" items="${listaGenero.generoLista()}">
									<option value="${listas.getGen_id()}">
											${listas.getGen_nome()}
									</option>
								</c:forEach>
							</select>
							<input type="hidden" id="selectedListaGenero" value="<%=gameBean.getGen_id()%>">
							<br>	
						</td>
						
											
						<td style="vertical-align: top; padding: 10px; border: solid 0px; height: 100px;">
							<table>
								<tr>
									<td style="border solid: 0px;">
										<label class="control-label">Capa:</label>
										<div class="capa">
    									 	<img id="blah" src="../capas/<%=(gameBean.getGame_capa() == null) ? "" : gameBean.getGame_capa() %>" alt="capa" class="img-rounded"/>
										</div>
									  
									    <input type='file' name="game_capa" value="<%=(gameBean.getGame_capa() == null) ? "" : gameBean.getGame_capa() %>" onchange="readURL(this);" />
									</td>
								</tr>
								
								<tr style="height: 13px; border: solid 0px;"></tr>
								<tr>
									<td>
										<div>
											<label class="control-label">Midia:</label>
											<select id="mid_id" name="mid_id">
												<jsp:useBean id="listaMidia" class="controllers.MidiaController"></jsp:useBean>
												<option>Selecione...</option>
												<c:forEach var="listas" items="${listaMidia.midiaLista()}">
													<option value="${listas.getMid_id()}">
														${listas.getMid_nome()}
													</option>							
												</c:forEach>
											</select>
											<input type="hidden" id="selectedMidia" value="<%=gameBean.getMid_id()%>">
										</div>
										<div>
											<label class="control-label">Plataforma:</label>
											<select id="pla_id" name="pla_id">
												<jsp:useBean id="listaPlataforma" class="controllers.PlataformaController"></jsp:useBean>
												<option>Selecione...</option>
												<c:forEach var="listas" items="${listaPlataforma.plataformaLista()}">
													<option value="${listas.getPla_id()}">
														${listas.getPla_nome()}
													</option>							
												</c:forEach>
											</select>
											<input type="hidden" id="selectedPlataforma" value="<%=gameBean.getPla_id()%>">
										</div>	
									</td>
								</tr>
							</table>
						</td>	
					</tr>
				</table>
				<table>
					<tr style=" border: solid 0px;">
						<td style="vertical-align: top; padding: 10px; border: solid 0px; height: 100px;">
							<div class="controls" style="width:478px;  height:100px; border: solid 0px;">
								<label class="control-label">Descri��o:</label>
								<textarea name="game_descricao" " 
								          rows="3" cols="5" style="width:460px;  height:50px; border: solid 1px #27408B;" placeholder="Descri��o"><%=(gameBean.getGame_descricao() == null) ? "" : gameBean.getGame_descricao() %></textarea>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div>
			<div
				style="float: left; width: 220px; height: 45px; border: solid 0px;">
				<div align="right">
					<input type="submit" value="Enviar"
						class="btn btn-large btn-primary" />
				</div>
			</div>

			<div
				style="float: right; width: 220px; height: 45px; border: solid 0px;">
				<!-- <div align="right" style="border:solid 1px;">  -->
				<div align="left">
					<a href="../views/index.jsp"> <input type="button"
						value="Voltar" class="btn btn-large btn-primary" />
					</a>
				</div>
			</div>
		</div>
	</form>
</div>