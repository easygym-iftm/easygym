package com.grupo6.easygym.dominio;

public class Cliente {
	private int cod_cli, cod_plano, cod_func, cod_estado;
	private String nome_cli, cpf_cli, email_cli, telefone_cli, cep_cli, end_cli, cidade_cli, plano;
	private Plano plano_c;
	private Estado estado;
	private Funcionario funcionario;
	
	


	public Cliente(int cod_cli, int cod_plano, int cod_func, int cod_estado, String nome_cli, String cpf_cli,
			String email_cli, String telefone_cli, String cep_cli, String end_cli, String cidade_cli, String plano,
			Plano plano_c, Estado estado, Funcionario funcionario) {
		super();
		this.cod_cli = cod_cli;
		this.cod_plano = cod_plano;
		this.cod_func = cod_func;
		this.cod_estado = cod_estado;
		this.nome_cli = nome_cli;
		this.cpf_cli = cpf_cli;
		this.email_cli = email_cli;
		this.telefone_cli = telefone_cli;
		this.cep_cli = cep_cli;
		this.end_cli = end_cli;
		this.cidade_cli = cidade_cli;
		this.plano = plano;
		this.plano_c = plano_c;
		this.estado = estado;
		this.funcionario = funcionario;
	}


	


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Estado getEstado() {
		return estado;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public int getCod_cli() {
		return cod_cli;
	}
	public int getCod_plano() {
		return cod_plano;
	}

	public int getCod_func() {
		return cod_func;
	}
	public String getNome_cli() {
		return nome_cli;
	}
	public String getCpf_cli() {
		return cpf_cli;
	}
	public String getEmail_cli() {
		return email_cli;
	}
	public String getTelefone_cli() {
		return telefone_cli;
	}
	public String getCep_cli() {
		return cep_cli;
	}
	public String getEnd_cli() {
		return end_cli;
	}
	public String getCidade_cli() {
		return cidade_cli;
	}
	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}
	public void setCod_plano(int cod_plano) {
		this.cod_plano = cod_plano;
	}
	public void setCod_func(int cod_func) {
		this.cod_func = cod_func;
	}
	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}
	public void setCpf_cli(String cpf_cli) {
		this.cpf_cli = cpf_cli;
	}
	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}
	public void setTelefone_cli(String telefone_cli) {
		this.telefone_cli = telefone_cli;
	}
	public void setCep_cli(String cep_cli) {
		this.cep_cli = cep_cli;
	}
	public void setEnd_cli(String end_cli) {
		this.end_cli = end_cli;
	}
	public void setCidade_cli(String cidade_cli) {
		this.cidade_cli = cidade_cli;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}
	public int getCod_estado() {
		return cod_estado;
	}
	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}
	public Plano getPlano_c() {
		return plano_c;
	}


	public void setPlano_c(Plano plano_c) {
		this.plano_c = plano_c;
	}
	
}
