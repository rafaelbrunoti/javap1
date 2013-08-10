package model.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.GameBean;
import model.connection.ODBCConnection;

public class GameModel {
	private ODBCConnection odbcConnection;
    private String sql;
    public GameModel gameModel;
    private PreparedStatement stmt;
	private ResultSet rs;
	
	public GameModel(){
		odbcConnection = new ODBCConnection();
	}
	
	public List<GameBean>  select(String sql){
        try{
            List<GameBean> gameLista = new ArrayList<GameBean>();
            
            sql = "select * from game";
            
            
            
            stmt  = odbcConnection.connect().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
            	
            	GameBean gameBean = new GameBean();

            	gameBean.setGame_id(rs.getInt("game_id"));
            	gameBean.setGame_nome(rs.getString("game_nome"));
            	gameBean.setGame_data(rs.getDate("game_data"));
            	gameBean.setGame_descricao(rs.getString("game_descricao"));
            	gameBean.setGame_capa(rs.getString("game_capa"));
            	gameBean.setGen_id(rs.getInt("gen_id"));
            	gameBean.setMid_id(rs.getInt("mid_id"));
            	gameBean.setPla_id(rs.getInt("pla_id"));
                
                gameLista.add(gameBean);
                
            }
            rs.close();
            stmt.close();                
            return gameLista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	

}
