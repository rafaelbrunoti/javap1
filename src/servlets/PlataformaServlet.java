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
       
    
    public PlataformaServlet() {
        super();
    }
    
    protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	
    	PlataformaController platarformaController = new PlataformaController();
    	
    	platarformaController.request = request;
    	platarformaController.response = response;
    	PlataformaBean plataformaBean = platarformaController.mostraDados();
    	platarformaController.save();
    	
    	out.println("Nome da Plataforma do Game: " + plataformaBean.getPla_nome());
    	out.println("Nome da Plataforma do Game: " + plataformaBean.getPla_descricao());
    	
    	try{
			
    		PlataformaController plaController = new PlataformaController();
			plaController.plataformaLista();
			RequestDispatcher rd = request
					.getRequestDispatcher("/views/plataforma/listaplataforma.jsp");
			rd.forward(request, response);
			
			//esse response.sendRedirect eu meio que inventei, não sei se vai dar certo!
			response.sendRedirect(request.getContextPath() + "/views/plataforma/listaplataforma.jsp");
			
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
