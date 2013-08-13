package controllers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.GameBean;
import model.models.GameModel;

public class GameController {
	
	public HttpServletRequest request;
	public HttpServletResponse response;
	public GameModel gameModel = null;
	
	public GameController(){
		gameModel = new GameModel();
	}
	
	public GameBean mostraDados() throws Exception{
		GameBean gameBean = new GameBean();
    	gameBean.setGame_id(Integer.parseInt(request.getParameter("game_id")));
    	gameBean.setGame_nome(request.getParameter("game_nome"));
    	
    	//Conversão de texto para Data
    	String dataEmTexto = request.getParameter("game_data");
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.setTime(data);
   	
    	gameBean.setGame_data(dataLancamento);
    	//
    	
    	gameBean.setGame_descricao(request.getParameter("game_descricao"));
    	gameBean.setGame_capa(request.getParameter("game_capa"));
    	gameBean.setGen_id(Integer.parseInt(request.getParameter("gen_id")));
    	gameBean.setMid_id(Integer.parseInt(request.getParameter("mid_id")));
    	gameBean.setPla_id(Integer.parseInt(request.getParameter("pla_id")));
		
		return gameBean;
	}
    
	public void save() throws Exception{
		
		GameModel gameModel = new GameModel();
		GameBean gameBean = new GameBean();
    	gameBean.setGame_id(Integer.parseInt(request.getParameter("game_id")));
    	gameBean.setGame_nome(request.getParameter("game_nome"));

    	//Conversão de texto para Data
    	String dataEmTexto = request.getParameter("game_data");
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		
		Calendar dataLancamento = Calendar.getInstance();
		dataLancamento.setTime(data);
   	
    	gameBean.setGame_data(dataLancamento);
    	//
    	
    	gameBean.setGame_descricao(request.getParameter("game_descricao"));
    	gameBean.setGame_capa(request.getParameter("game_capa"));
    	gameBean.setGen_id(Integer.parseInt(request.getParameter("gen_id")));
    	gameBean.setMid_id(Integer.parseInt(request.getParameter("mid_id")));
    	gameBean.setPla_id(Integer.parseInt(request.getParameter("pla_id")));
		
		gameModel.insert(gameBean);
		System.out.println(request.getParameter("game_nome"));
	}
	
	public List<GameBean> gameLista(){
		return gameModel.select("");
	}
		
}
