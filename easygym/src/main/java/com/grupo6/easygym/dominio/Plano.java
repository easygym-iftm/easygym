package com.grupo6.easygym.dominio;

public class Plano {
	
	private int cod_plano, cod_horario;
	private String nome_plano;
	private float valor_mensal;
	private Horario horario;
	
	
	
	
	public Plano(int cod_plano, String nome_plano, int cod_horario, float valor_mensal, Horario horario) {
		super();
		this.cod_plano = cod_plano;
		this.nome_plano = nome_plano;
		this.cod_horario = cod_horario;
		this.valor_mensal = valor_mensal;
		this.horario = horario;
	}
	
	public Plano(String nome_plano, int cod_horario, float valor_mensal, Horario horario) {
		super();
		this.cod_horario = cod_horario;
		this.nome_plano = nome_plano;
		this.valor_mensal = valor_mensal;
		this.horario = horario;
	}
	
	
	public Plano() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCod_plano() {
		return cod_plano;
	}
	public int getCod_horario() {
		return cod_horario;
	}
	public float getValor_mensal() {
		return valor_mensal;
	}
	public void setCod_plano(int cod_plano) {
		this.cod_plano = cod_plano;
	}
	public void setCod_horario(int cod_horario) {
		this.cod_horario = cod_horario;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public void setValor_mensal(float valor_mensal) {
		this.valor_mensal = valor_mensal;
	}

	public String getNome_plano() {
		return nome_plano;
	}

	public void setNome_plano(String nome_plano) {
		this.nome_plano = nome_plano;
	}
	

}
