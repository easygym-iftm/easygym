package com.grupo6.easygym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo6.easygym.dominio.CargaHoraria;
import com.grupo6.easygym.dominio.Cargo;
import com.grupo6.easygym.dominio.DiasTrabalho;
import com.grupo6.easygym.dominio.Estado;

public class OutrosDAO {

	public List<Estado> todos(){
		List<Estado> lista = new ArrayList<Estado>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from estados";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  int cod_estado = resultado.getInt("cod_estado");
				  String sigla = resultado.getString("sigla");
				  String descricao = resultado.getString("descricao");
				  Estado estado = new Estado(cod_estado, sigla, descricao);
				  lista.add(estado);				  
			  }
			  resultado.close();
			  stmt.close();
			  conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public List<CargaHoraria> todosCarga(){
		List<CargaHoraria> lista = new ArrayList<CargaHoraria>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from cargahoraria";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  int cod_carga_hor = resultado.getInt("cod_carga_hor");
				  String carga_horaria = resultado.getString("carga_horaria");
				  CargaHoraria carga = new CargaHoraria(cod_carga_hor, carga_horaria);
				  lista.add(carga);				  
			  }
			  resultado.close();
			  stmt.close();
			  conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public List<Cargo> todosCargo(){
		List<Cargo> lista = new ArrayList<Cargo>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from cargo";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  int cod_cargo = resultado.getInt("cod_cargo");
				  String funcao = resultado.getString("funcao");
				  Cargo cargo = new Cargo(cod_cargo, funcao);
				  lista.add(cargo);				  
			  }
			  resultado.close();
			  stmt.close();
			  conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public List<DiasTrabalho> todosDiasTrabalho(){
		List<DiasTrabalho> lista = new ArrayList<DiasTrabalho>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from diautil";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  int cod_dias_trab = resultado.getInt("cod_dias_trab");
				  String dias_trab = resultado.getString("dias_trab");
				  DiasTrabalho dias = new DiasTrabalho(cod_dias_trab, dias_trab);
				  lista.add(dias);				  
			  }
			  resultado.close();
			  stmt.close();
			  conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
