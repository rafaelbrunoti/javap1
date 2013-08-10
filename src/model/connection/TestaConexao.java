package model.connection;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.beans.PessoaBean;
import model.connection.ODBCConnection;
import model.models.PessoaModel;

public class TestaConexao {

	public static void main(String[]args){
		ODBCConnection odbcConnection = new ODBCConnection();
		
		Controller controller = new Controller();

	    controller.gameLista();
		
		 
		 for GameBean gameBean : controller.gameLista()){
			 System.out.println( gameBean.getEmail());
		 }
		 
		 
		//controller.request = request;
		//controller.response = response;
		
		//controller.save();
		//controller.list();
		
		
		/*try{
			System.out.println("Conexao Aberta! " + odbcConnection.connect());
			
		}catch(Exception e){
			System.out.println(e);
		}*/
	}

}
