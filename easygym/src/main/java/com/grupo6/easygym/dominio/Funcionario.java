package com.grupo6.easygym.dominio;

public class Funcionario {

	private int cod_func, cod_cargo, cod_estado, cod_dias_trab, cod_carga_hor;
	private String nome_func, cpf_func, email_func, telefone_func, cep_func, end_func, cidade_func;
	private String carga_horaria, funcao, dias_trab, sigla;
	private float salario;
	
	
	
	
	
	
	public Funcionario(int cod_func, int cod_cargo, int cod_estado, int cod_dias_trab, int cod_carga_hor,
			String nome_func, String cpf_func, String email_func, String telefone_func, String cep_func,
			String end_func, String cidade_func, String carga_horaria, String funcao, String dias_trab, String sigla,
			float salario) {
		super();
		this.cod_func = cod_func;
		this.cod_cargo = cod_cargo;
		this.cod_estado = cod_estado;
		this.cod_dias_trab = cod_dias_trab;
		this.cod_carga_hor = cod_carga_hor;
		this.nome_func = nome_func;
		this.cpf_func = cpf_func;
		this.email_func = email_func;
		this.telefone_func = telefone_func;
		this.cep_func = cep_func;
		this.end_func = end_func;
		this.cidade_func = cidade_func;
		this.carga_horaria = carga_horaria;
		this.funcao = funcao;
		this.dias_trab = dias_trab;
		this.sigla = sigla;
		this.salario = salario;
	}

	

	public Funcionario(int cod_func, String nome_func) {
		super();
		this.cod_func = cod_func;
		this.nome_func = nome_func;
	}



	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCod_carga_hor() {
		return cod_carga_hor;
	}

	public void setCod_carga_hor(int cod_carga_hor) {
		this.cod_carga_hor = cod_carga_hor;
	}

	public int getCod_func() {
		return cod_func;
	}
	public int getCod_cargo() {
		return cod_cargo;
	}
	public int getCod_estado() {
		return cod_estado;
	}
	public int getCod_dias_trab() {
		return cod_dias_trab;
	}
	public String getNome_func() {
		return nome_func;
	}
	public String getCpf_func() {
		return cpf_func;
	}
	public String getEmail_func() {
		return email_func;
	}
	public String getTelefone_func() {
		return telefone_func;
	}
	public String getCep_func() {
		return cep_func;
	}
	public String getEnd_func() {
		return end_func;
	}
	public String getCidade_func() {
		return cidade_func;
	}
	public float getSalario() {
		return salario;
	}
	public void setCod_func(int cod_func) {
		this.cod_func = cod_func;
	}
	public void setCod_cargo(int cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}
	public void setCod_dias_trab(int cod_dias_trab) {
		this.cod_dias_trab = cod_dias_trab;
	}
	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}
	public void setCpf_func(String cpf_func) {
		this.cpf_func = cpf_func;
	}
	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}
	public void setTelefone_func(String telefone_func) {
		this.telefone_func = telefone_func;
	}
	public void setCep_func(String cep_func) {
		this.cep_func = cep_func;
	}
	public void setEnd_func(String end_func) {
		this.end_func = end_func;
	}
	public void setCidade_func(String cidade_func) {
		this.cidade_func = cidade_func;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}



	public String getCarga_horaria() {
		return carga_horaria;
	}
	public String getFuncao() {
		return funcao;
	}
	public String getDias_trab() {
		return dias_trab;
	}
	public String getSigla() {
		return sigla;
	}
	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public void setDias_trab(String dias_trab) {
		this.dias_trab = dias_trab;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
	
}
