package com.grupo6.easygym.dominio;

public class DiasTrabalho {

	private int cod_dias_trab;
	private String dias_trab;
	
	public DiasTrabalho(int cod_dias_trab, String dias_trab)
	{
		super();
		this.cod_dias_trab = cod_dias_trab;
		this.dias_trab = dias_trab;
	}
	
	public int getCod_dias_trab() {
		return cod_dias_trab;
	}
	
	public String getDias_trab() {
		return dias_trab;
	}
	
	public void setCod_dias_trab(int cod_dias_trab) {
		this.cod_dias_trab = cod_dias_trab;
	}
	
	public void setDias_trab(String dias_trab) {
		this.dias_trab = dias_trab;
	}
	
}
