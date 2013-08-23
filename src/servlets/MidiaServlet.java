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
       
    
    public MidiaServlet() {
        super();
    }
    
    protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	
    	MidiaController midiaController = new MidiaController();
    	
    	midiaController.request = request;
    	midiaController.response = response;
    	MidiaBean midiaBean = midiaController.mostraDados();
    	midiaController.save();
    	
    	out.println("Nome da Midia do Game : " + midiaBean.getMid_nome());
    	
    	try{
			
    		MidiaController mdController = new MidiaController();
			mdController.midiaLista();
			RequestDispatcher rd = request
					.getRequestDispatcher("/views/midia/listamidia.jsp");
			rd.forward(request, response);
			
			//esse response.sendRedirect eu meio que inventei, não sei se vai dar certo!
			response.sendRedirect(request.getContextPath() + "/views/midia/listamidia.jsp");
			
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
