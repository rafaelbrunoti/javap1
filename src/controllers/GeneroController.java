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
	public GeneroBean generoBean;
	
	private Integer gen_id;
	
	public Integer getGen_id() {
		return gen_id;
	}
	
	public void setGen_id(Integer gen_id) {
		this.gen_id = gen_id;
	}
	
	public GeneroController(){
		generoModel = new GeneroModel();
		generoBean = new GeneroBean();
	}
	
	
    public void save(){
		
		String gen_id = request.getParameter("gen_id");
		generoBean.setGen_nome(request.getParameter("gen_nome"));
		generoBean.setGen_descricao(request.getParameter("gen_descricao"));
		
		if ((gen_id == null)||(gen_id.trim().length() == 0)){
			generoModel.insert(generoBean);
		
		}else{
			generoBean.setGen_id(Integer.parseInt(gen_id));
			generoModel.altera(generoBean);
		}
		
		System.out.println(request.getParameter("gen_nome"));
	}
	
    public void delete(){

		String gen_id = request.getParameter("gen_id");
		generoBean.setGen_id(Integer.parseInt(gen_id));
		generoModel.remove(generoBean);
	}
    
    
	public List<GeneroBean> generoLista(){		
		return generoModel.select(generoBean);
	}
	
	public GeneroBean generoPorId(){
		if (getGen_id()!= null){
			generoBean.setGen_id(getGen_id());
			return generoModel.select(generoBean).get(0);
		}else
			return generoBean;
	}

}
