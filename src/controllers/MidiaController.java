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
	
	
    public void save(){
		
		MidiaModel midiaModel = new MidiaModel();
		MidiaBean midiaBean = new MidiaBean();
		
		//generoBean.setGen_id(Integer.parseInt(request.getParameter("gen_id")));
		midiaBean.setMid_nome(request.getParameter("nome"));
		
		midiaModel.insert(midiaBean);
		System.out.println(request.getParameter("nome"));
	}
	
	public List<MidiaBean> midiaLista(){
		return midiaModel.select("");
	}

}
