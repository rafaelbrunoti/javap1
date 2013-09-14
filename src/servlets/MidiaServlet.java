package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.MidiaBean;
import controllers.MidiaController;


@WebServlet("/MidiaServlet")
public class MidiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		MidiaController controller = new MidiaController();
		controller.request = request;
		controller.response = response;
		
		String midiaNome = request.getParameter("nome");
		
		//Criação do objeto model
		MidiaBean bean = new MidiaBean();
		bean.setMid_nome(midiaNome);
		controller.save();
		
		response.sendRedirect(request.getContextPath() + "/views/?view=midia/midia-lista");	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.execute(request, response);

	}

}
