package com.grupo6.easygym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo6.easygym.dominio.Funcionario;

public class FuncionarioDAO {
	

	public void inserir(Funcionario funcionario) throws SQLException {
		  Connection conexao = FabricaDeConexao.getConnection();
		  String sql = "INSERT INTO funcionario( nome_func, cpf_func, email_func, telefone_func, "
		  		+ "cep_func, end_func, cidade_func, cod_estado, cod_cargo, cod_dias_trab, cod_carga_hor, salario) "
		  		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		  PreparedStatement stmt = conexao.prepareStatement(sql);
		  stmt.setString(1,funcionario.getNome_func());
		  stmt.setString(2, funcionario.getCpf_func());
		  stmt.setString(3,funcionario.getEmail_func());
		  stmt.setString(4, funcionario.getTelefone_func());
		  stmt.setString(5,funcionario.getCep_func());
		  stmt.setString(6, funcionario.getEnd_func());
		  stmt.setString(7,funcionario.getCidade_func());
		  stmt.setInt(8,funcionario.getCod_estado());
		  stmt.setInt(9,funcionario.getCod_cargo());
		  stmt.setInt(10,funcionario.getCod_dias_trab());
		  stmt.setInt(11,funcionario.getCod_carga_hor());
		  stmt.setFloat(12, funcionario.getSalario());
		  stmt.execute();
		  stmt.close();
		  conexao.close();
		}
	

	public void deletar(int id) {
		String sql = "delete from funcionario where cod_func=" + id;

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			consulta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Funcionario buscaPorId(int i) {
		String sql = "SELECT * FROM funcionario f, cargahoraria ca, cargo c, diautil d, estados e "
				+ "WHERE f.cod_estado=e.cod_estado AND f.cod_cargo=c.cod_cargo "
				+ "AND f.cod_dias_trab=d.cod_dias_trab AND f.cod_carga_hor=ca.cod_carga_hor AND f.cod_func="+i+";";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			ResultSet resultado = consulta.executeQuery();
			resultado.next();
			Funcionario func= extracted(resultado);
			
			return func;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizar(Funcionario func) {
		String sql = "UPDATE funcionario SET nome_func=?, cpf_func=?, email_func=?, telefone_func=?,"
				+ "cep_func=?,end_func=?,cidade_func=?,cod_estado=?,cod_cargo=?,cod_dias_trab=?,"
				+ "cod_carga_hor=?,salario=? WHERE cod_func=?;";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);	
			consulta.setString(1, func.getNome_func());
			consulta.setString(2, func.getCpf_func());
			consulta.setString(3, func.getEmail_func());
			consulta.setString(4, func.getTelefone_func());
			consulta.setString(5, func.getCep_func());
			consulta.setString(6, func.getEnd_func());
			consulta.setString(7, func.getCidade_func());
			consulta.setInt(8, func.getCod_estado());
			consulta.setInt(9, func.getCod_cargo());
			consulta.setInt(10, func.getCod_dias_trab());
			consulta.setInt(11, func.getCod_carga_hor());
			consulta.setFloat(12, func.getSalario() );
			consulta.setInt(13, func.getCod_func());
			consulta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Funcionario extracted(ResultSet resultado) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setCod_func(resultado.getInt("cod_func"));
		funcionario.setNome_func(resultado.getString("nome_func"));
		funcionario.setCpf_func(resultado.getString("cpf_func"));
		funcionario.setEmail_func(resultado.getString("email_func"));
		funcionario.setTelefone_func(resultado.getString("telefone_func"));
		funcionario.setCep_func(resultado.getString("cep_func"));
		funcionario.setEnd_func(resultado.getString("end_func"));
		funcionario.setCidade_func(resultado.getString("cidade_func"));
		funcionario.setCod_estado(resultado.getInt("cod_estado"));
		funcionario.setCod_cargo(resultado.getInt("cod_cargo"));
		funcionario.setCod_dias_trab(resultado.getInt("cod_dias_trab"));
		funcionario.setCod_carga_hor(resultado.getInt("cod_carga_hor"));
		funcionario.setSalario(resultado.getFloat("salario"));

		funcionario.setCarga_horaria(resultado.getString("carga_horaria"));
		funcionario.setSigla(resultado.getString("sigla"));
		funcionario.setFuncao(resultado.getString("funcao"));
		funcionario.setDias_trab(resultado.getString("dias_trab"));
		return funcionario;
	}
	
	public List<Funcionario> todos(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "SELECT * FROM funcionario f, cargahoraria ca, cargo c, diautil d, estados e "
				+ "WHERE f.cod_estado=e.cod_estado AND f.cod_cargo=c.cod_cargo "
				+ "AND f.cod_dias_trab=d.cod_dias_trab AND f.cod_carga_hor=ca.cod_carga_hor ORDER BY cod_func";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  Funcionario funcionario = extracted(resultado);
				  lista.add(funcionario);
				  
			  }
			  resultado.close();
			  stmt.close();
			  conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	public List<Funcionario> todosInstrutores(){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "SELECT * FROM funcionario f, cargahoraria ca, cargo c, diautil d, estados e "
				+ "				WHERE f.cod_estado=e.cod_estado AND f.cod_cargo=c.cod_cargo "
				+ "				AND f.cod_dias_trab=d.cod_dias_trab AND f.cod_carga_hor=ca.cod_carga_hor AND f.cod_cargo=4";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  Funcionario funcionario = extracted(resultado);
				  lista.add(funcionario);
				  
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
