package com.grupo6.easygym.dominio;

public class Horario {

	private int cod_horario;
	String horario, faixa_horario;
	
	
	
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Horario(int cod_horario, String horario, String faixa_horario) {
		super();
		this.cod_horario = cod_horario;
		this.horario = horario;
		this.faixa_horario = faixa_horario;
	}
	public int getCod_horario() {
		return cod_horario;
	}
	public String getHorario() {
		return horario;
	}
	public String getFaixa_horario() {
		return faixa_horario;
	}
	public void setCod_horario(int cod_horario) {
		this.cod_horario = cod_horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public void setFaixa_horario(String faixa_horario) {
		this.faixa_horario = faixa_horario;
	}
	
	

}
