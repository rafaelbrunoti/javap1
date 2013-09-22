package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;

import model.beans.GameBean;
import model.beans.GeneroBean;
import model.models.GameModel;

public class GameController {
	
	public HttpServletRequest request;
	public HttpServletResponse response;
	public GameModel gameModel = null;
	public GameBean gameBean = null;
	
	private Integer game_id;
	
	public Integer getGame_id() {
		return game_id;
	}
	
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	
	public GameController(){
		gameModel = new GameModel();
		gameBean = new GameBean();
	}
    
	public void save(){
		
		String game_id = request.getParameter("game_id");
   
		//Convertendo data em String
    	String dataEmTexto = request.getParameter("game_data");
    	Calendar game_data = null;
    	try {
    		if (dataEmTexto != null){    			
    			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
    			game_data = Calendar.getInstance();
    			game_data.setTime(data);
    		}
    	} catch (ParseException e) {
    		System.out.println("Erro de conversão de data!");
    		return; //Para a execução do Metodo
    	}
    	//Fim da conversao
    	
    	gameBean.setGame_data(game_data);
    	gameBean.setGame_nome(request.getParameter("game_nome"));
    	gameBean.setGame_descricao(request.getParameter("game_descricao"));
    	gameBean.setGame_capa(request.getParameter("game_capa"));
    	gameBean.setGen_id(Integer.parseInt(request.getParameter("gen_id")));
    	gameBean.setMid_id(Integer.parseInt(request.getParameter("mid_id")));
    	gameBean.setPla_id(Integer.parseInt(request.getParameter("pla_id")));
    	
    	if ((game_id == null)||(game_id.trim().length() == 0)){
			gameModel.insert(gameBean);
		
		}else{
			gameBean.setGame_id(Integer.parseInt(game_id));
			gameModel.altera(gameBean);
		}
		
		System.out.println(request.getParameter("game_nome"));
	}
	
		
	public void delete(){

		String game_id = request.getParameter("game_id");
		gameBean.setGame_id(Integer.parseInt(game_id));
		gameModel.remove(gameBean);
	}
	    
	    
		public List<GameBean> gameLista(){		
			return gameModel.select(gameBean);
		}
		
		public GameBean gamePorId(){
			if (getGame_id()!= null){
				gameBean.setGame_id(getGame_id());
				return gameModel.select(gameBean).get(0);
			}else
				return gameBean;
		}		
}
