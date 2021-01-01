package com.grupo6.easygym.dominio;

public class Estado {

	private int cod_estado;
	private String sigla, descricao;
	

	
	public Estado(int cod_estado, String sigla, String descricao) {
		super();
		this.cod_estado = cod_estado;
		this.sigla = sigla;
		this.descricao = descricao;
		
	}
	
	
	
	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCod_estado() {
		return cod_estado;
	}

	public String getSigla() {
		return sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
