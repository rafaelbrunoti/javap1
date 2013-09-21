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
import model.beans.PlataformaBean;
import controllers.PlataformaController;

@WebServlet("/PlataformaServlet")
public class PlataformaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlataformaController controller = new PlataformaController();
		controller.request = request;
		controller.response = response;
		
		String plataformaId	 = request.getParameter("pla_id");
		String plataformaNome = request.getParameter("pla_nome");
		String plataformaDescricao = request.getParameter("pla_descricao");
		
		//Criação do objeto model
		PlataformaBean bean = new PlataformaBean();
				
		//If para verificar se é cadastro ou alteração
		if ((plataformaId.trim().length() != 0)){
		    bean.setPla_id(Integer.parseInt(plataformaId));
		}
				
		bean.setPla_nome(plataformaNome);
		bean.setPla_descricao(plataformaDescricao);
				
		if(request.getParameter("acao") == null){
			controller.save();
		}else
		{
			controller.delete();
		}
		
		response.sendRedirect(request.getContextPath() + "/views/?view=plataforma/plataforma-lista");		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.execute(request, response);

	}

}
