package model.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.MidiaBean;
import model.connection.ODBCConnection;

public class MidiaModel {
	
	private ODBCConnection odbcConnection;
    private String sql;
    public MidiaModel midiaModel;
    private PreparedStatement stmt;
	private ResultSet rs;
	
	public MidiaModel(){
		odbcConnection = new ODBCConnection();
	}
	
	public MidiaModel insert(MidiaBean midiaBean){
		
		sql = "insert into midia (mid_nome) VALUES ("
				     +"'"+midiaBean.getMid_nome()+"')";
		
		try{		
			
			stmt = odbcConnection.connect().prepareStatement(sql);
			stmt.execute();
			stmt.close();
			
		}catch(SQLException E){
			System.out.println(E.getMessage());
		}

		
		System.out.println(sql);
		
		return midiaModel;
		
	}
	public List<MidiaBean>  select(String sql){
        try{
            List<MidiaBean> midiaLista = new ArrayList<MidiaBean>();
            
            sql = "select * from midia";
            
            
            
            stmt  = odbcConnection.connect().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
            	
            	MidiaBean midiaBean = new MidiaBean();

            	midiaBean.setMid_id(rs.getInt("mid_id"));
            	midiaBean.setMid_nome(rs.getString("mid_nome"));
                
                midiaLista.add(midiaBean);
                
            }
            rs.close();
            stmt.close();                
            return midiaLista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	
	public void altera(MidiaBean midiaBean){
	      
        String sql = "update midia set mid_nome=? where mid_id=?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setString(1, midiaBean.getMid_nome());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void remove(MidiaBean midiaBean){
        String sql = "delete from midia where mid_id =?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setInt(1, midiaBean.getMid_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
