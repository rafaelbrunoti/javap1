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
		
		sql = "INSERT INTO genero (gen_nome, gen_descricao) VALUES ("
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
	
	public List<GeneroBean>  select(GeneroBean generoBean){
        try{
            List<GeneroBean> generoLista = new ArrayList<GeneroBean>();
            String sql = "SELECT * FROM genero WHERE 1=1 ";
            
            if (generoBean.getGen_id() != null ){
            	sql += "AND gen_id = "+generoBean.getGen_id();
            }
            
            
            stmt  = odbcConnection.connect().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
            	
            	GeneroBean genero = new GeneroBean();

            	genero.setGen_id(rs.getInt("gen_id"));
            	genero.setGen_nome(rs.getString("gen_nome"));
            	genero.setGen_descricao(rs.getString("gen_descricao"));
                
                generoLista.add(genero);
                
            }
            rs.close();
            stmt.close();                
            return generoLista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	
	public void altera(GeneroBean generoBean){
	      
        String sql = "UPDATE genero SET gen_nome=?, gen_descricao=? WHERE gen_id=?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setString(1, generoBean.getGen_nome());
            stmt.setString(2, generoBean.getGen_descricao());
            stmt.setInt(3, generoBean.getGen_id());
            
            System.out.println(stmt.toString()); 
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void remove(GeneroBean generoBean){
        String sql = "DELETE FROM genero WHERE gen_id =?";
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
