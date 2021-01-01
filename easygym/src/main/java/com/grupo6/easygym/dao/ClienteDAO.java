package com.grupo6.easygym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grupo6.easygym.dominio.Cliente;
import com.grupo6.easygym.dominio.Estado;
import com.grupo6.easygym.dominio.Funcionario;
import com.grupo6.easygym.dominio.Horario;
import com.grupo6.easygym.dominio.Plano;


public class ClienteDAO {
	public void inserir(Cliente cliente) throws SQLException {
		  Connection conexao = FabricaDeConexao.getConnection();
		  String sql = "insert into cliente" +
				"(cod_cli, nome_cli, cpf_cli, email_cli, telefone_cli, cep_cli, end_cli, cidade_cli, "
				+ "cod_estado, cod_plano, cod_func)" +
				" values (?,?,?,?,?,?,?,?,?,?,?)";
		  PreparedStatement stmt = conexao.prepareStatement(sql);
		  stmt.setInt(1,cliente.getCod_cli());
		  stmt.setString(2, cliente.getNome_cli());
		  stmt.setString(3, cliente.getCpf_cli());
		  stmt.setString(4, cliente.getEmail_cli());
		  stmt.setString(5, cliente.getTelefone_cli());
		  stmt.setString(6,cliente.getCep_cli());
		  stmt.setString(7, cliente.getEnd_cli());
		  stmt.setString(8, cliente.getCidade_cli());
		  stmt.setInt(9, cliente.getCod_estado());
		  stmt.setInt(10, cliente.getCod_plano());
		  stmt.setInt(11, cliente.getCod_func());
		  stmt.execute();
		  stmt.close();
		  conexao.close();
		}
	
	public void deletar(int id) {
		String sql = "delete from cliente where cod_cli=" + id;

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			consulta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private Cliente extracted(ResultSet resultado) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setCod_cli(resultado.getInt("cod_cli"));
		cliente.setNome_cli(resultado.getString("nome_cli"));
		cliente.setCpf_cli(resultado.getString("cpf_cli"));
		cliente.setEmail_cli(resultado.getString("email_cli"));
		cliente.setTelefone_cli(resultado.getString("telefone_cli"));
		cliente.setCep_cli(resultado.getString("cep_cli"));
		cliente.setEnd_cli(resultado.getString("end_cli"));
		cliente.setCidade_cli(resultado.getString("cidade_cli"));
		cliente.setCod_estado(resultado.getInt("cod_estado"));
		cliente.setCod_plano(resultado.getInt("cod_plano"));
		cliente.setCod_func(resultado.getInt("cod_func"));
		return cliente;
	}
	
	public Cliente buscaPorId(int i) {
		String sql = "select * from cliente c, plano p, funcionario f, horario h, estados e WHERE p.cod_horario = h.cod_horario AND c.cod_plano=p.cod_plano AND c.cod_func=f.cod_func AND c.cod_estado=e.cod_estado AND c.cod_cli="+i+" ORDER BY cod_cli;";
		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);
			ResultSet resultado = consulta.executeQuery();
			resultado.next();
			Cliente cliente = extracted(resultado);
			
			  Horario horario = new Horario();
			  horario.setCod_horario(resultado.getInt("cod_horario"));
			  horario.setHorario(resultado.getString("horario"));
			  horario.setFaixa_horario(resultado.getString("faixa_horario"));
			  
			  Plano plano = new Plano();
			  plano.setCod_plano(resultado.getInt("cod_plano"));
			  plano.setCod_horario(resultado.getInt("cod_horario"));
			  plano.setNome_plano(resultado.getString("nome_plano"));
			  plano.setValor_mensal(resultado.getFloat("valor_mensal"));
			  plano.setHorario(horario);
			  
			  Funcionario funcionario = new Funcionario();
			  funcionario.setCod_func(resultado.getInt("cod_func"));
			  funcionario.setNome_func(resultado.getString("nome_func"));
			  
			  Estado estado = new Estado();
			  estado.setCod_estado(resultado.getInt("cod_estado"));
			  estado.setSigla(resultado.getString("sigla"));
			  estado.setDescricao(resultado.getString("descricao"));
			  
			  cliente.setFuncionario(funcionario);
			  cliente.setEstado(estado);
			  cliente.setPlano_c(plano);
			  
			return cliente;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizar(Cliente cliente) {
		String sql = "UPDATE cliente SET nome_cli=?,cpf_cli=?,email_cli=?,telefone_cli=?,"
				+ "cep_cli=?,end_cli=?,cidade_cli=?,cod_estado=?,cod_plano=?,cod_func=? WHERE cod_cli = ?;";

		try {
			PreparedStatement consulta =
					FabricaDeConexao.getConnection().prepareStatement(sql);	
			consulta.setString(1, cliente.getNome_cli());
			consulta.setString(2, cliente.getCpf_cli());
			consulta.setString(3, cliente.getEmail_cli());
			consulta.setString(4, cliente.getTelefone_cli());
			consulta.setString(5, cliente.getCep_cli());
			consulta.setString(6, cliente.getEnd_cli());
			consulta.setString(7, cliente.getCidade_cli());
			consulta.setInt(8, cliente.getCod_estado());
			consulta.setInt(9, cliente.getCod_plano());
			consulta.setInt(10, cliente.getCod_func());
			consulta.setInt(11, cliente.getCod_cli());
			consulta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Cliente> todos(){
		List<Cliente> lista = new ArrayList<Cliente>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from cliente c, plano p, funcionario f, horario h WHERE p.cod_horario = h.cod_horario AND c.cod_plano=p.cod_plano AND c.cod_func=f.cod_func ORDER BY cod_cli;";
		
		try {
			 PreparedStatement stmt = conexao.prepareStatement(sql);
			  ResultSet resultado = stmt.executeQuery();
			  while (resultado.next()) {
				  
				  Cliente cliente = extracted(resultado);
				  
				  Horario horario = new Horario();
				  horario.setCod_horario(resultado.getInt("cod_horario"));
				  horario.setHorario(resultado.getString("horario"));
				  horario.setFaixa_horario(resultado.getString("faixa_horario"));
				  
				  Plano plano = new Plano();
				  plano.setCod_plano(resultado.getInt("cod_plano"));
				  plano.setCod_horario(resultado.getInt("cod_horario"));
				  plano.setNome_plano(resultado.getString("nome_plano"));
				  plano.setValor_mensal(resultado.getFloat("valor_mensal"));
				  plano.setHorario(horario);
				  
				  Funcionario funcionario = new Funcionario();
				  funcionario.setCod_func(resultado.getInt("cod_func"));
				  funcionario.setNome_func(resultado.getString("nome_func"));
				  
				  
				  cliente.setFuncionario(funcionario);
				  
				  cliente.setPlano_c(plano);
				  
				  lista.add(cliente);
				  
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
