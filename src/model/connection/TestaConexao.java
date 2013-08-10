package model.connection;

import java.util.ArrayList;
import java.util.List;


import controllers.GameController;
import model.beans.GameBean;
import model.connection.ODBCConnection;

public class TestaConexao {

	public static void main(String[]args){
		ODBCConnection odbcConnection = new ODBCConnection();
		
		GameController controller = new GameController();

	    controller.gameLista();
		
		 
		 for (GameBean gameBean : controller.gameLista()){
			 System.out.println( gameBean.getGame_nome());
		 }
		 
		 
		//controller.request = request;
		//controller.response = response;
		
		//controller.save();
		//controller.list();
		
		
		try{
			System.out.println("Conexao Aberta! " + odbcConnection.connect());
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
