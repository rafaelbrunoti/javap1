package model.beans;

import java.util.Date;

public class GameBean {
	
	private Integer game_id;
	private String game_nome;
	private Date game_data;
	private String game_descricao;
	private String game_capa;
	private Integer gen_id;
	private Integer pla_id;
	private Integer mid_id;	
	
	
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	public String getGame_nome() {
		return game_nome;
	}
	public void setGame_nome(String game_nome) {
		this.game_nome = game_nome;
	}
	public Date getGame_data() {
		return game_data;
	}
	public void setGame_data(Date game_data) {
		this.game_data = game_data;
	}
	public String getGame_descricao() {
		return game_descricao;
	}
	public void setGame_descricao(String game_descricao) {
		this.game_descricao = game_descricao;
	}
	public String getGame_capa() {
		return game_capa;
	}
	public void setGame_capa(String game_capa) {
		this.game_capa = game_capa;
	}
	public Integer getGen_id() {
		return gen_id;
	}
	public void setGen_id(Integer gen_id) {
		this.gen_id = gen_id;
	}
	public Integer getPla_id() {
		return pla_id;
	}
	public void setPla_id(Integer pla_id) {
		this.pla_id = pla_id;
	}
	public Integer getMid_id() {
		return mid_id;
	}
	public void setMid_id(Integer mid_id) {
		this.mid_id = mid_id;
	}
	
}