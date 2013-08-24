package model.connection;

import controllers.GameController;
import model.beans.GameBean;
import model.connection.ODBCConnection;

public class TestaConexao {

	public static void main(String[]args) throws Exception{
		ODBCConnection odbcConnection = new ODBCConnection();
		
		GameController controller = new GameController();
		
		GameBean bean = new GameBean();
		
	    controller.save();
		
		 
		// for (GameBean gameBean : controller.gameLista()){
		//	 System.out.println( gameBean.getGame_nome());
		//}
		 
		 
		//controller.request = request;
		//controller.response = response;
		//GameBean gameBean = new GameBean();

		 
		 controller.save();
		//controller.list();
		
		
		/*try{
			System.out.println("Conexao Aberta! " + odbcConnection.connect());
			
		}catch(Exception e){
			System.out.println(e);
		}*/
	}

}
