package model.beans;

import java.util.Calendar;

public class GameBean {
	
	private Integer game_id;
	private String game_nome;
	private Calendar game_data;
	private String game_descricao;
	private String game_capa;
	private Integer gen_id;
	private String gen_nome;
	private Integer pla_id;
	private String pla_nome;
	private Integer mid_id;	
	private String mid_nome;	
	
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
	public Calendar getGame_data() {
		return game_data;
	}
	public void setGame_data(Calendar game_data) {
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
	public String getGen_nome() {
		return gen_nome;
	}
	public void setGen_nome(String gen_nome) {
		this.gen_nome = gen_nome;
	}
	public String getPla_nome() {
		return pla_nome;
	}
	public void setPla_nome(String pla_nome) {
		this.pla_nome = pla_nome;
	}
	public String getMid_nome() {
		return mid_nome;
	}
	public void setMid_nome(String mid_nome) {
		this.mid_nome = mid_nome;
	}
	
}
