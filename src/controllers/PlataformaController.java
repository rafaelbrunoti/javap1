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
	
    public void save(){
		
		PlataformaModel plataformaModel = new PlataformaModel();
		PlataformaBean plataformaBean = new PlataformaBean();
		
		plataformaBean.setPla_nome(request.getParameter("nome"));
		plataformaBean.setPla_descricao(request.getParameter("descricao"));
				
		plataformaModel.insert(plataformaBean);
		System.out.println(request.getParameter("game_nome"));
	}
	
	public List<PlataformaBean> plataformaLista(){
		return plataformaModel.select("");
	}
}
