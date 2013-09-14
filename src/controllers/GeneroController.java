package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.GeneroBean;
import model.models.GeneroModel;

public class GeneroController {
	public HttpServletRequest request;
	public HttpServletResponse response;
	public GeneroModel generoModel;
	
	public GeneroController(){
		generoModel = new GeneroModel();
	}
	
	
    public void save(){
		
		GeneroModel generoModel = new GeneroModel();
		GeneroBean generoBean = new GeneroBean();
		
		String gen_id = request.getParameter("gen_id");
		generoBean.setGen_nome(request.getParameter("nome"));
		generoBean.setGen_descricao(request.getParameter("descricao"));
		
		if ((gen_id == null)||(gen_id.trim().length() == 0)){
			generoModel.insert(generoBean);
		
		}else{
			generoBean.setGen_id(Integer.parseInt(gen_id));
			generoModel.altera(generoBean);
		}
		
		System.out.println(request.getParameter("nome"));
	}
	
    public void delete(){
		
		GeneroModel generoModel = new GeneroModel();
		GeneroBean generoBean = new GeneroBean();
		
		String gen_id = request.getParameter("gen_id");
		generoBean.setGen_id(Integer.parseInt(gen_id));
		generoModel.remove(generoBean);
	}
    
    
	public List<GeneroBean> generoLista(){
		return generoModel.select("");
	}

}
