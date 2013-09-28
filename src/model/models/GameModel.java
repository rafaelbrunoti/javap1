package model.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.beans.GameBean;
import model.beans.GeneroBean;
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
		
		sql = "INSERT INTO game (game_nome, game_data, game_descricao, game_capa, gen_id, pla_id, mid_id) VALUES (?,?,?,?,?,?,?)";		
		
		try{		
			
			stmt = odbcConnection.connect().prepareStatement(sql);
			
			stmt.setString(1, gameBean.getGame_nome());
			stmt.setDate(2, new Date(gameBean.getGame_data().getTimeInMillis()));
			stmt.setString(3, gameBean.getGame_descricao());
			stmt.setString(4, gameBean.getGame_capa());
			stmt.setInt(5, gameBean.getGen_id());
			stmt.setInt(6, gameBean.getPla_id());
			stmt.setInt(7, gameBean.getMid_id());

			stmt.execute();
			stmt.close();
			
		}catch(SQLException E){
			System.out.println(E.getMessage());
		}

		
		System.out.println(sql);
		
		return gameModel;
		
	}
	
	public List<GameBean>  select(GameBean gameBean){
        try{
        	 List<GameBean> gameLista = new ArrayList<GameBean>();
             String sql = "SELECT game.*, gen_nome, mid_nome, pla_nome FROM game " +
            			    "INNER JOIN genero gen on gen.gen_id = game.gen_id "+
            			    "INNER JOIN midia mid on mid.mid_id = game.mid_id "+
            			    "INNER JOIN plataforma pla on pla.pla_id = game.pla_id "+
            			  "WHERE 1=1 ";
             
             if (gameBean.getGame_id() != null ){
             	sql += "and game_id = "+gameBean.getGame_id();
             }
             
             
             stmt  = odbcConnection.connect().prepareStatement(sql);
             
             rs = stmt.executeQuery();
             
             while (rs.next()){
            	
            	GameBean game = new GameBean();

            	game.setGame_id(rs.getInt("game_id"));
            	game.setGame_nome(rs.getString("game_nome"));
            	
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("game_data"));         	           	
                game.setGame_data(data);
            	           
                game.setGame_descricao(rs.getString("game_descricao"));
                game.setGame_capa(rs.getString("game_capa"));
                game.setGen_id(rs.getInt("gen_id"));
                game.setGen_nome(rs.getString("gen_nome"));
                game.setMid_id(rs.getInt("mid_id"));
                game.setMid_nome(rs.getString("mid_nome"));
                game.setPla_id(rs.getInt("pla_id"));
                game.setPla_nome(rs.getString("pla_nome"));
                
                gameLista.add(game);
                
            }
            rs.close();
            stmt.close();                
            return gameLista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	
	public void altera(GameBean gameBean){
	      
        String sql = "UPDATE game SET game_nome=?, game_data=?, game_descricao=?, gen_id=?, pla_id=?, mid_id=? WHERE game_id=?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setString(1, gameBean.getGame_nome());
            stmt.setDate(2, new Date(gameBean.getGame_data().getTimeInMillis()));
            stmt.setString(3, gameBean.getGame_descricao());
            stmt.setInt(4, gameBean.getGen_id());
            stmt.setInt(5, gameBean.getMid_id());
            stmt.setInt(6, gameBean.getPla_id());
            stmt.setInt(7, gameBean.getGame_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void remove(GameBean gameBean){
        String sql = "DELETE FROM game WHERE game_id =?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            System.out.println(gameBean.getGame_id());
            stmt.setInt(1, gameBean.getGame_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
