package model.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.MidiaBean;
import model.beans.PlataformaBean;
import model.connection.ODBCConnection;

public class PlataformaModel {
	
	private ODBCConnection odbcConnection;
    private String sql;
    public PlataformaModel plataformaModel;
    private PreparedStatement stmt;
	private ResultSet rs;
	
	public PlataformaModel(){
		odbcConnection = new ODBCConnection();
	}
	
	public PlataformaModel insert(PlataformaBean plataformaBean){
		
		sql = "INSERT INTO plataforma (pla_nome, pla_descricao) VALUES ("
				     +"'"+plataformaBean.getPla_nome()+"',"
				     +"'"+plataformaBean.getPla_descricao()+"')";
		
		try{		
			
			stmt = odbcConnection.connect().prepareStatement(sql);
			stmt.execute();
			stmt.close();
			
		}catch(SQLException E){
			System.out.println(E.getMessage());
		}

		
		System.out.println(sql);
		
		return plataformaModel;
		
	}
	
	public List<PlataformaBean>  select(PlataformaBean plataformaBean){
        try{
            List<PlataformaBean> plataformaLista = new ArrayList<PlataformaBean>();
            String sql = "SELECT * FROM plataforma WHERE 1=1 ";
            
            if (plataformaBean.getPla_id() != null ){
            	sql += "AND pla_id = "+plataformaBean.getPla_id();
            }
            
            
            stmt  = odbcConnection.connect().prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
            	
            	PlataformaBean plataforma = new PlataformaBean();

            	plataforma.setPla_id(rs.getInt("pla_id"));
            	plataforma.setPla_nome(rs.getString("pla_nome"));
            	plataforma.setPla_descricao(rs.getString("pla_descricao"));
                
            	plataformaLista.add(plataforma);
                
            }
            rs.close();
            stmt.close();                
            return plataformaLista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
	
	public void altera(PlataformaBean plataformaBean){
	      
        String sql = "UPDATE plataforma SET pla_nome=?, pla_descricao=? WHERE pla_id=?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setString(1, plataformaBean.getPla_nome());
            stmt.setString(2, plataformaBean.getPla_descricao());
            stmt.setInt(3, plataformaBean.getPla_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void remove(PlataformaBean plataformaBean){
        String sql = "DELETE FROM plataforma WHERE pla_id =?";
        try {
            PreparedStatement stmt = odbcConnection.connect().prepareStatement(sql);
            stmt.setInt(1, plataformaBean.getPla_id());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
