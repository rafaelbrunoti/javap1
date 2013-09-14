package logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.GeneroController;

public class LoadAltera {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{

		GeneroController controller = new GeneroController();
		controller.request = request;
		controller.response = response;
		
		String generoId = request.getParameter("id");
		String generoNome = request.getParameter("nome");
		String generoDescricao = request.getParameter("descricao");
		
		
		request.setAttribute("id", generoId);
		request.setAttribute("nome", generoNome);
		request.setAttribute("descricao", generoDescricao);
        
		String url = "?view=genero/genero-cadastro.jsp";	
		request.setAttribute("url", url);  
	}
}
