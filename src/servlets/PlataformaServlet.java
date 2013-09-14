package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.PlataformaBean;
import controllers.PlataformaController;

@WebServlet("/PlataformaServlet")
public class PlataformaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		PlataformaController controller = new PlataformaController();
		controller.request = request;
		controller.response = response;
		
		String plataformaNome = request.getParameter("nome");
		String plataformaDescricao = request.getParameter("descricao");
		
		//Criação do objeto model
		PlataformaBean bean = new PlataformaBean();
		bean.setPla_nome(plataformaNome);
		bean.setPla_descricao(plataformaDescricao);
		controller.save();
		
		response.sendRedirect(request.getContextPath() + "/views/?view=plataforma/plataforma-lista");		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.execute(request, response);

	}

}
