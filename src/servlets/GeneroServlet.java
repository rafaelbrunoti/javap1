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
       
    
    public GeneroServlet() {
        super();
    }
    
    protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	
    	GeneroController generoController = new GeneroController();
    	
    	generoController.request = request;
    	generoController.response = response;
    	GeneroBean generoBean = new GeneroBean();
    	generoController.save();
    	
    	out.println("Nome do Genero do Game : " + generoBean.getGen_nome());
    	out.println("Nome do Genero do Game : " + generoBean.getGen_descricao());
    	
    	try{
			
    		GeneroController gnController = new GeneroController();
			gnController.generoLista();
			RequestDispatcher rd = request
					.getRequestDispatcher("/views/genero/genero-lista.jsp");
			rd.forward(request, response);
			
			//esse response.sendRedirect eu meio que inventei, não sei se vai dar certo!
			response.sendRedirect(request.getContextPath() + "/views/genero/genero-lista.jsp");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
    }	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

}
