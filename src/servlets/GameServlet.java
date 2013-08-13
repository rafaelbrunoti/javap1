package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.GameBean;

import controllers.GameController;


@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GameServlet() {
        super();
    }
    
    protected void execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
    	
    	GameController gameController = new GameController();
    	
    	gameController.request = request;
    	gameController.response = response;
    	GameBean gameBean = gameController.mostraDados();
    	gameController.save();
    	
    	out.println("Nome do Game: " + gameBean.getGame_nome());
		out.println("Data do Game: " + gameBean.getGame_data());
		out.println("Descricao do Game: " + gameBean.getGame_descricao());
		out.println("Capa do Game: " + gameBean.getGame_capa());
		out.println("Data do Game: " + gameBean.getGen_id());
		out.println("ID da Plataforma do Game: " + gameBean.getPla_id());
		out.println("ID da Midia do Game: " + gameBean.getMid_id());
    	
    	try{
    		GameController gmController = new GameController();
			gmController.gameLista();
			RequestDispatcher rd = request
					.getRequestDispatcher("/listaGames.jsp");
			rd.forward(request, response);
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
