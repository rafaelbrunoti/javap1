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
	public MidiaBean midiaBean;
	
	private Integer mid_id;
	
	public Integer getMid_id() {
		return mid_id;
	}
	
	public void setMid_id(Integer mid_id) {
		this.mid_id = mid_id;
	}
	
	public MidiaController(){
		midiaModel = new MidiaModel();
		midiaBean = new MidiaBean();
	}
	
	
    public void save(){
		
		String mid_id = request.getParameter("mid_id");
		midiaBean.setMid_nome(request.getParameter("mid_nome"));
		
		if ((mid_id == null)||(mid_id.trim().length() == 0)){
			midiaModel.insert(midiaBean);
		
		}else{
			midiaBean.setMid_id(Integer.parseInt(mid_id));
			midiaModel.altera(midiaBean);
		}
		
		System.out.println(request.getParameter("mid_nome"));
	}
	
    public void delete(){

		String mid_id = request.getParameter("mid_id");
		midiaBean.setMid_id(Integer.parseInt(mid_id));
		midiaModel.remove(midiaBean);
	}
    
    
	public List<MidiaBean> midiaLista(){		
		return midiaModel.select(midiaBean);
	}
	
	public MidiaBean midiaPorId(){
		if (getMid_id()!= null){
			midiaBean.setMid_id(getMid_id());
			return midiaModel.select(midiaBean).get(0);
		}else
			return midiaBean;
	}

}
