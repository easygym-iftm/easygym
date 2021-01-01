package com.grupo6.easygym.dominio;

public class Cargo {

	private int cod_cargo;
	private String funcao;
	

	
	public Cargo(int cod_cargo, String funcao)
	{
		super();
		this.cod_cargo = cod_cargo;
		this.funcao = funcao;
	}
		
	public int getCod_cargo() {
		return cod_cargo;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setCod_cargo(int cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
