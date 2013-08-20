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
			this.setView("inicio");
			
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

		this.pages.add("game/inicio");
		this.pages.add("game/lista");
		this.pages.add("game/cadastro");
		this.pages.add("genero/lista");
		this.pages.add("genero/cadastro");
		this.pages.add("plataforma/lista");
		this.pages.add("plataforma/cadastro");
		this.pages.add("midia/lista");
		this.pages.add("midia/cadastro");

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