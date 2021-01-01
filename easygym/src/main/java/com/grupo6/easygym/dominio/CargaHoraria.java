package com.grupo6.easygym.dominio;

public class CargaHoraria {

	private int cod_carga_hor;
	private String carga_horaria;
	
	public CargaHoraria(int cod_carga_hor, String carga_horaria) {
		super();
		this.cod_carga_hor = cod_carga_hor;
		this.carga_horaria = carga_horaria;
		
	}
	
	public int getCod_carga_hor() {
		return cod_carga_hor;
	}
	
	public String getCarga_horaria() {
		return carga_horaria;
	}
	
	public void setCod_carga_hor(int cod_carga_hor) {
		this.cod_carga_hor = cod_carga_hor;
	}
	
	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
}
