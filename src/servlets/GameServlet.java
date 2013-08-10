package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import controller.Controller;
//import controllers.ExampleController;


@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GameServlet() {
        super();
    }
    
    protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//    	ExampleController control = new ExampleController();
//    	
//    	control.request = req;
//    	control.response = resp;
//    	control.save();
//    	
//    	try{
//    		ExampleController control = new ExampleController();
//			control.list();
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/views/pessoa/pessoa.jsp");
//			rd.forward(request, response);
//		}
//		catch(Exception e){
//			System.out.println(e.getMessage());
//		}
	}
    	
    	
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.execute(request, response);
	}

}
