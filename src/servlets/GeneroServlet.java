package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import model.beans.GeneroBean;
import controllers.GeneroController;


@WebServlet("/GeneroServlet")
public class GeneroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		GeneroController controller = new GeneroController();
		controller.request = request;
		controller.response = response;
		
		String generoId = request.getParameter("id");
		String generoNome = request.getParameter("nome");
		String generoDescricao = request.getParameter("descricao");
		
		//Criação do objeto model
		GeneroBean bean = new GeneroBean();
		
		//If para verificar se é cadastro ou alteração
		if ((generoId.trim().length() != 0)){
     	   bean.setGen_id(Integer.parseInt(generoId));
		}
		
		bean.setGen_nome(generoNome);
		bean.setGen_descricao(generoDescricao);
		
		if(request.getParameter("acao") == null){
			controller.save();
		}else
		{
			controller.delete();
		}
		
		
		response.sendRedirect(request.getContextPath() + "/views/?view=genero/genero-lista");		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.execute(request, response);

	}

}
