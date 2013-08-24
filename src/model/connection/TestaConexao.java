package model.connection;

import model.beans.GeneroBean;
import model.connection.ODBCConnection;
import model.models.GeneroModel;

public class TestaConexao {

	public static void main(String[]args) throws Exception{
		ODBCConnection odbcConnection = new ODBCConnection();
		
		GeneroModel generoModel = new GeneroModel();
		
		GeneroBean bean = new GeneroBean();
		
		bean.setGen_nome("Esportes");
		bean.setGen_descricao("Futebol, Volei, Basquete, esportes em geral");
		
	    generoModel.insert(bean);
		
		 
		// for (GameBean gameBean : controller.gameLista()){
		//	 System.out.println( gameBean.getGame_nome());
		//}
		 
		 
		//controller.request = request;
		//controller.response = response;
		//GameBean gameBean = new GameBean();

		//controller.list();
		
		
		/*try{
			System.out.println("Conexao Aberta! " + odbcConnection.connect());
			
		}catch(Exception e){
			System.out.println(e);
		}*/
	}

}
