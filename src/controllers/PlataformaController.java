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
	public PlataformaBean plataformaBean;
	
	private Integer pla_id;
	
	public Integer getPla_id() {
		return pla_id;
	}
	
	public void setPla_id(Integer pla_id) {
		this.pla_id = pla_id;
	}
	
	public PlataformaController(){
		plataformaModel = new PlataformaModel();
		plataformaBean = new PlataformaBean();
	}
	
	
    public void save(){
		
		String pla_id = request.getParameter("pla_id");
		plataformaBean.setPla_nome(request.getParameter("pla_nome"));
		plataformaBean.setPla_descricao(request.getParameter("pla_descricao"));
		
		if ((pla_id == null)||(pla_id.trim().length() == 0)){
			plataformaModel.insert(plataformaBean);
		
		}else{
			plataformaBean.setPla_id(Integer.parseInt(pla_id));
			plataformaModel.altera(plataformaBean);
		}
		
		System.out.println(request.getParameter("pla_nome"));
	}
	
    public void delete(){

		String pla_id = request.getParameter("pla_id");
		plataformaBean.setPla_id(Integer.parseInt(pla_id));
		plataformaModel.remove(plataformaBean);
	}
    
    
	public List<PlataformaBean> plataformaLista(){		
		return plataformaModel.select(plataformaBean);
	}
	
	public PlataformaBean plataformaPorId(){
		if (getPla_id()!= null){
			plataformaBean.setPla_id(getPla_id());
			return plataformaModel.select(plataformaBean).get(0);
		}else
			return plataformaBean;
	}

}
