package com.grupo6.easygym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo6.easygym.dominio.Horario;

public class HorarioDAO {
	
	public void inserir(Horario horario) throws SQLException {
		  Connection conexao = FabricaDeConexao.getConnection();
		  String sql = "insert into horario	" +
				"(cod_horario, horario, faixa_horario)" +
				" values (?,?,?)";
		  PreparedStatement stmt = conexao.prepareStatement(sql);
		  stmt.setInt(1,horario.getCod_horario());
		  stmt.setString(2, horario.getHorario());
		  stmt.setString(3, horario.getFaixa_horario());
		  stmt.execute();
		  stmt.close();
		  conexao.close();
		}
	

	public void deletar(int id) {
		String sql = "delete from horario where cod_horario=" + id;

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			consulta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Horario buscaPorId(int i) {
		String sql = "select * from horario where cod_horario=" +i+";";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			ResultSet resultado = consulta.executeQuery();
			resultado.next();
			Horario horario = extracted(resultado);
			return horario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Horario extracted(ResultSet resultado) throws SQLException {
		Horario horario = new Horario();
		horario.setCod_horario(resultado.getInt("cod_horario"));
		horario.setHorario(resultado.getString("horario"));
		horario.setFaixa_horario(resultado.getString("faixa_horario"));
		return horario;
	}
	
	public void atualizar(Horario horario) {
		String sql = "UPDATE horario"
				+ " SET horario=?, faixa_horario=?"
				+ " WHERE cod_horario = ?; ";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);		
			consulta.setString(1, horario.getHorario());
			consulta.setString(2, horario.getFaixa_horario());
			consulta.setInt(3, horario.getCod_horario());
			consulta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Horario> todos(){
		List<Horario> lista = new ArrayList<Horario>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from horario order by cod_horario";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  int cod_horario = resultado.getInt("cod_horario");
				  String nome_horario = resultado.getString("horario");
				  String faixa_horario = resultado.getString("faixa_horario");
				  Horario horario = new Horario(cod_horario, nome_horario, faixa_horario);
				  lista.add(horario);
				  
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
