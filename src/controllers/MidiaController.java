package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.MidiaBean;
import model.models.MidiaModel;

public class MidiaController {
	public HttpServletRequest request;
	public HttpServletResponse response;
	public MidiaModel midiaModel;
	
	public MidiaController(){
		midiaModel = new MidiaModel();
	}
	
	public MidiaBean mostraDados(){
		
		MidiaBean midiaBean = new MidiaBean();
		
		midiaBean.setMid_id(Integer.parseInt(request.getParameter("mid_id")));
		midiaBean.setMid_nome(request.getParameter("mid_nome"));
		
		return midiaBean;
	}
	
	public void save(){
		
		MidiaBean midiaBean = new MidiaBean();
		MidiaModel midiaModel = new MidiaModel();
		
		midiaBean.setMid_id(Integer.parseInt(request.getParameter("mid_id")));
		midiaBean.setMid_nome(request.getParameter("mid_nome"));
		
		midiaModel.insert(midiaBean);
	}
	
	public List<MidiaBean> midiaLista(){
		return midiaModel.select("");
	}

}
