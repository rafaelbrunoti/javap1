package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.PlataformaBean;
import model.models.PlataformaModel;

public class PlataformaController {
	public HttpServletRequest request;
	public HttpServletResponse response;
	public PlataformaModel plataformaModel;
	
	public PlataformaController(){
		plataformaModel = new PlataformaModel();
	}
	
	public PlataformaBean mostraDados(){
		
		PlataformaBean plataformaBean = new PlataformaBean();
		
		plataformaBean.setPla_id(Integer.parseInt(request.getParameter("pla_id")));
		plataformaBean.setPla_nome(request.getParameter("pla_nome"));
		plataformaBean.setPla_descricao(request.getParameter("pla_descricao"));
    	
		return plataformaBean;
	}
	
    public void save(){
		
		PlataformaModel plataformaModel = new PlataformaModel();
		PlataformaBean plataformaBean = new PlataformaBean();
		
		plataformaBean.setPla_id(Integer.parseInt(request.getParameter("pla_id")));
		plataformaBean.setPla_nome(request.getParameter("pla_nome"));
		plataformaBean.setPla_descricao(request.getParameter("pla_descricao"));
				
		plataformaModel.insert(plataformaBean);
		System.out.println(request.getParameter("game_nome"));
	}
	
	public List<PlataformaBean> plataformaLista(){
		return plataformaModel.select("");
	}
}
