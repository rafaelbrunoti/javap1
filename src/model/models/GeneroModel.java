package model.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.GeneroBean;
import model.connection.ODBCConnection;

public class GeneroModel {
	
	private ODBCConnection odbcConnection;
    private String sql;
    public GeneroModel generoModel;
    private PreparedStatement stmt;
	private ResultSet rs;
	
	public GeneroModel(){
		odbcConnection = new ODBCConnection();
	}
	
	public GeneroModel insert(GeneroBean generoBean){
		
		sql = "insert into genero (gen_nome, gen_descricao) VALUES ("
				     +"'"+generoBean.getGen_nome()+"',"
				     +"'"+generoBean.getGen_descricao()+"')";
		
		try{		
			
			stmt = odbcConnection.connect().prepareStatement(sql);
			stmt.execute();
			stmt.close();
			
		}catch(SQLException E){
			System.out.println(E.getMessage());
		}

		
		System.out.println(sql);
		
		return generoModel;
		
	}
	public List<GeneroBean>  select(String sql){
        try{
            List<GeneroBean> generoLista = new ArrayList<GeneroBean>();
            
            sql = "select * from genero";
            
            
            
            stmt  = odbcConnection.connect().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
            	
            	GeneroBean generoBean = new GeneroBean();

            	generoBean.setGen_id(rs.getInt("gen_id"));
            	generoBean.setGen_nome(rs.getString("gen_nome"));
            	generoBean.setGen_descricao(rs.getString("gen_descricao"));
                
                generoLista.add(generoBean);
                
            }
            rs.close();
            stmt.close();                
            return generoLista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	
	public void altera(GeneroBean generoBean){
	      
        String sql = "update genero set gen_nome=?, gen_descricao=? where gen_id=?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setString(1, generoBean.getGen_nome());
            stmt.setString(2, generoBean.getGen_descricao());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void remove(GeneroBean generoBean){
        String sql = "delete from genero where gen_id =?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setInt(1, generoBean.getGen_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
