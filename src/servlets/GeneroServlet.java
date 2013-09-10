package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String generoNome = request.getParameter("nome");
		String generoDescricao = request.getParameter("descricao");
		
		//Criação do objeto model
		GeneroBean bean = new GeneroBean();
		bean.setGen_nome(generoNome);
		bean.setGen_descricao(generoDescricao);
		controller.save();
		
		response.sendRedirect(request.getContextPath() + "/views/?view=genero/genero-lista");		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.execute(request, response);

	}

}
