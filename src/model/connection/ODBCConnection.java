package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ODBCConnection {
	
	public Connection odbcConnection = null;
	
	public Connection connect(){
		try{
			Class.forName("com." + Config.driver_development + ".jdbc.Driver").newInstance();
			
			odbcConnection = (Connection) DriverManager.getConnection("jdbc:"
					+ Config.driver_development +"://"
					+ Config.host_development + "/"
					+ Config.db_development,Config.user_development,Config.pass_development);
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		return odbcConnection;
	}
	
	public static void main(String[]args){
		ODBCConnection odbcConnection = new ODBCConnection();
		try{
			System.out.println("Conexao Aberta! " + odbcConnection.connect());
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
