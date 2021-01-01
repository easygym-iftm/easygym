package com.grupo6.easygym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo6.easygym.dominio.Horario;
import com.grupo6.easygym.dominio.Plano;

public class PlanoDAO {

	public void inserir(Plano plano) throws SQLException {
		  Connection conexao = FabricaDeConexao.getConnection();
		  String sql = "insert into plano	" +
				"(nome_plano, cod_horario, valor_mensal)" +
				" values (?,?,?)";
		  PreparedStatement stmt = conexao.prepareStatement(sql);
		  stmt.setString(1,plano.getNome_plano());
		  stmt.setInt(2, plano.getCod_horario());
		  stmt.setFloat(3, plano.getValor_mensal());
		  stmt.execute();
		  stmt.close();
		  conexao.close();
		}
	

	public void deletar(int id) {
		String sql = "delete from plano where cod_plano=" + id;

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			consulta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Plano buscaPorId(int i) {
		String sql = "select * from plano, horario where plano.cod_horario=horario.cod_horario AND plano.cod_plano=" +i+";";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			ResultSet resultado = consulta.executeQuery();
			resultado.next();
			Plano plano = extracted(resultado);
			Horario horario = new Horario();
			horario.setCod_horario(resultado.getInt("cod_horario"));
			horario.setHorario(resultado.getString("horario"));
			horario.setFaixa_horario(resultado.getString("faixa_horario"));
			plano.setHorario(horario);
			
			return plano;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizar(Plano plano) {
		String sql = "UPDATE plano"
				+ " SET nome_plano=?, cod_horario=?, valor_mensal=?"
				+ " WHERE cod_plano = ?; ";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);	
			consulta.setString(1, plano.getNome_plano());
			consulta.setInt(2, plano.getCod_horario());
			consulta.setFloat(3, plano.getValor_mensal());
			consulta.setInt(4, plano.getCod_plano());
			consulta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Plano extracted(ResultSet resultado) throws SQLException {
		Plano plano = new Plano();
		plano.setCod_plano(resultado.getInt("cod_plano"));
		plano.setNome_plano(resultado.getString("nome_plano"));
		plano.setCod_horario(resultado.getInt("cod_horario"));
		plano.setValor_mensal(resultado.getFloat("valor_mensal"));
		return plano;
	}
	
	public List<Plano> todos(){
		List<Plano> lista = new ArrayList<Plano>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from plano, horario where plano.cod_horario=horario.cod_horario order by cod_plano";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  Plano plano = extracted(resultado);
				  Horario horario = new Horario();
				  horario.setCod_horario(resultado.getInt("cod_horario"));
				  horario.setHorario(resultado.getString("horario"));
				  horario.setFaixa_horario(resultado.getString("faixa_horario"));
				  
				  plano.setHorario(horario);
				  lista.add(plano);
				  
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
