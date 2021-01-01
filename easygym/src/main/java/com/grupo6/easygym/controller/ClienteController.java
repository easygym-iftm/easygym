package com.grupo6.easygym.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo6.easygym.dao.ClienteDAO;
import com.grupo6.easygym.dao.FuncionarioDAO;
import com.grupo6.easygym.dao.HorarioDAO;
import com.grupo6.easygym.dao.OutrosDAO;
import com.grupo6.easygym.dao.PlanoDAO;
import com.grupo6.easygym.dominio.CargaHoraria;
import com.grupo6.easygym.dominio.Cargo;
import com.grupo6.easygym.dominio.Cliente;
import com.grupo6.easygym.dominio.DiasTrabalho;
import com.grupo6.easygym.dominio.Estado;
import com.grupo6.easygym.dominio.Funcionario;
import com.grupo6.easygym.dominio.Horario;
import com.grupo6.easygym.dominio.Plano;

@Controller
public class ClienteController {
	
	private OutrosDAO outrosDAO;
	private ClienteDAO clienteDAO;
	private PlanoDAO planoDAO;
	private FuncionarioDAO funcionarioDAO;
	
	public ClienteController() {
		super();
		outrosDAO = new OutrosDAO();
		clienteDAO = new ClienteDAO();
		planoDAO = new PlanoDAO();
		funcionarioDAO = new FuncionarioDAO();
	}

	@RequestMapping("/ger-clientes")
	public String clienteTabela(Model modelo) {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "ger-clientes";
		
	}
	
	@RequestMapping("/clientes")
	public String mostrarFormularioCliente(Model modelo) {
		Cliente cliente = new Cliente();
		List<Estado> estados = outrosDAO.todos();
		List<Plano> plano = planoDAO.todos();
		List<Funcionario> func = funcionarioDAO.todosInstrutores();
		modelo.addAttribute("cliente", cliente);
		modelo.addAttribute("listaDeEstados", estados);
		modelo.addAttribute("listaDePlanos", plano);
		modelo.addAttribute("listaDeFuncionarios", func);
		return "clientes";
		
	}
	@PostMapping("/cad-cliente")
	public String processaFormulario(Cliente cliente) throws SQLException {
		ClienteDAO dao = new ClienteDAO();
		dao.inserir(cliente);
		return "redirect:/vis-cliente";
		
	}
	@RequestMapping("/edit-cliente")
	public String exibeFormEditCliente(@RequestParam("cod_cli") int i, Model modelo) {
		Cliente cliente = clienteDAO.buscaPorId(i);
		List<Estado> estados = outrosDAO.todos();
		List<Plano> plano = planoDAO.todos();
		List<Funcionario> func = funcionarioDAO.todosInstrutores();
		modelo.addAttribute("cliente", cliente);
		modelo.addAttribute("listaDeEstados", estados);
		modelo.addAttribute("listaDePlanos", plano);
		modelo.addAttribute("listaDeFuncionarios", func);
		return "edit-cliente";
	}
	
	@PostMapping("/editar-cliente")
	public String processaFormularioEditCliente(Cliente cliente) throws SQLException {
		ClienteDAO dao = new ClienteDAO();
		dao.atualizar(cliente);
		return "redirect:/ger-clientes";
		
	}
	@RequestMapping("/vis-cliente")
	public String clienteVerCliente(@RequestParam("cod_cli") int i, Model model) {
		Cliente cliente = clienteDAO.buscaPorId(i);
		List<Estado> estados = outrosDAO.todos();
		model.addAttribute("cliente", cliente);
		return "vis-cliente";
		
}
	
	@GetMapping("/excluir-cliente")
	public String deletar(@RequestParam("cod_cli") int i) {
		clienteDAO.deletar(i);
		return "redirect:/ger-clientes";
	}

}
