package controllers;

import java.util.ArrayList;

public class ViewController {

	public String view;
	public ArrayList<String> pages = new ArrayList<String>();

	public String content() {

		System.out.print("Array de paginas setado | ");
		this.setArrayPages();
		
		System.out.print("Pagina buscada: " + this.view + " | ");

		if (this.view == null || this.view == "" || this.view.isEmpty()) {
			
			System.out.print("Nenhum parametro de pagina encontrado, setando pagina padrão | ");
			this.setView("/views/index.jsp");
			
		} else {
			if (this.verifyPage(this.view)) {
				this.setView("" + this.view + ".jsp");
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

		this.pages.add("/views/index");
		this.pages.add("/games/lista");
		this.pages.add("/games/cadastro");
		this.pages.add("/generos/lista");
		this.pages.add("/generos/cadastro");
		this.pages.add("/plataformas/lista");
		this.pages.add("/plataformas/cadastro");
		this.pages.add("/midias/lista");
		this.pages.add("/midias/cadastro");

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