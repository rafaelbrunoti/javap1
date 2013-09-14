package controllers;

import java.util.ArrayList;

public class ViewController {

	public String view;
	public ArrayList<String> pages = new ArrayList<String>();

	public String content() {

		this.setArrayPages();
		System.out.print("Array de paginas setado | ");
		
		System.out.print("Pagina buscada: " + this.view + " | ");

		if (this.view == null || this.view == "" || this.view.isEmpty()) {
			
			System.out.print("Nenhum parametro de pagina encontrado, setando pagina padrão | ");
			this.setView("inicio.jsp");
			
		} else {
			if (this.verifyPage(this.view)) {
				this.setView("" + this.view);
			} else {
				this.setView("404.jsp");
			}
		}

		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public void setArrayPages() {

		try{
			this.pages.add("inicio.jsp");
			this.pages.add("game/game-lista.jsp");
			this.pages.add("game/game-cadastro.jsp");
			this.pages.add("genero/genero-lista.jsp");
			this.pages.add("genero/genero-cadastro.jsp");
			this.pages.add("plataforma/plataforma-lista.jsp");
			this.pages.add("plataforma/plataforma-cadastro.jsp");
			this.pages.add("midia/midia-lista.jsp");
			this.pages.add("midia/midia-cadastro.jsp");
		}catch(Exception e){
			System.out.println("Erro ao setar paginas");
		}
	}

	public Boolean verifyPage(String page) {

		Boolean pageExist = false;

		if (this.pages.contains(page)) {
			pageExist = true;
		}

		System.out.println(pageExist.equals(false) ? "A pagina não exite na lista | ":"Pagina existente | ");
		
		return pageExist;
	}

}