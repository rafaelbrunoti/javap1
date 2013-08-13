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
	
	public GeneroBean mostraDados(){
		
		GeneroBean generoBean = new GeneroBean();
		
		generoBean.setGen_id(Integer.parseInt(request.getParameter("gen_id")));
		generoBean.setGen_nome(request.getParameter("gen_nome"));
		generoBean.setGen_descricao(request.getParameter("gen_descricao"));
    	
		return generoBean;
	}
	
    public void save(){
		
		GeneroModel generoModel = new GeneroModel();
		GeneroBean generoBean = new GeneroBean();
		
		generoBean.setGen_id(Integer.parseInt(request.getParameter("gen_id")));
		generoBean.setGen_nome(request.getParameter("gen_nome"));
		generoBean.setGen_descricao(request.getParameter("gen_descricao"));
		
		generoModel.insert(generoBean);
		System.out.println(request.getParameter("game_nome"));
	}
	
	public List<GeneroBean> generoLista(){
		return generoModel.select("");
	}

}
