package model.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public GameModel insert(GameBean gameBean){
		
		sql = "insert into game (game_nome, game_data, game_descricao, game_capa, gen_id, pla_id, mid_id) VALUES ("
				     +"'"+gameBean.getGame_nome()+"',"
				     +"'"+gameBean.getGame_data()+"',"
				     +"'"+gameBean.getGame_descricao()+"',"
				     +"'"+gameBean.getGame_capa()+"',"
				     +"'"+gameBean.getGen_id()+"',"
				     +"'"+gameBean.getPla_id()+"',"
				     +"'"+gameBean.getMid_id()+"')";
		
		try{		
			
			stmt = odbcConnection.connect().prepareStatement(sql);
			stmt.execute();
			stmt.close();
			
		}catch(SQLException E){
			System.out.println(E.getMessage());
		}

		
		System.out.println(sql);
		
		return gameModel;
		
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
            	
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("game_data"));         	           	
            	gameBean.setGame_data(data);
            	           
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
	
	public void altera(GameBean gameBean){
	      
        String sql = "update game set game_nome=?, game_data=?, game_descricao=?, gen_id=?, pla_id=?, mid_id=? where game_id=?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setString(1, gameBean.getGame_nome());
            stmt.setDate(2, new Date(gameBean.getGame_data().getTimeInMillis()));
            stmt.setString(3, gameBean.getGame_descricao());
            stmt.setInt(4, gameBean.getGen_id());
            stmt.setInt(5, gameBean.getMid_id());
            stmt.setInt(6, gameBean.getPla_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void remove(GameBean gameBean){
        String sql = "delete from game where game_id =?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setInt(1, gameBean.getGame_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
