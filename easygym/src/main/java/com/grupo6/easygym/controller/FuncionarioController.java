package com.grupo6.easygym.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo6.easygym.dao.FuncionarioDAO;
import com.grupo6.easygym.dao.HorarioDAO;
import com.grupo6.easygym.dao.OutrosDAO;
import com.grupo6.easygym.dao.PlanoDAO;
import com.grupo6.easygym.dominio.CargaHoraria;
import com.grupo6.easygym.dominio.Cargo;
import com.grupo6.easygym.dominio.DiasTrabalho;
import com.grupo6.easygym.dominio.Estado;
import com.grupo6.easygym.dominio.Funcionario;
import com.grupo6.easygym.dominio.Horario;
import com.grupo6.easygym.dominio.Plano;

@Controller
public class FuncionarioController {
	
	private FuncionarioDAO funcionarioDAO;
	private OutrosDAO outrosDAO;
	
	public FuncionarioController() {
		super();
		funcionarioDAO = new FuncionarioDAO();
		outrosDAO = new OutrosDAO();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/funcionarios")
	public String mostrarFormularioFuncionario(Model modelo) {
		Funcionario func = new Funcionario();
		List<Estado> estados = outrosDAO.todos();
		List<CargaHoraria> carga = outrosDAO.todosCarga();
		List<Cargo> cargo = outrosDAO.todosCargo();
		List<DiasTrabalho> dias = outrosDAO.todosDiasTrabalho();
		modelo.addAttribute("func", func);
		modelo.addAttribute("listaDeEstados", estados);
		modelo.addAttribute("listaDeCargos", cargo);
		modelo.addAttribute("listaDeCargaHoraria", carga);
		modelo.addAttribute("listaDeDiasTrab", dias);
		return "funcionarios";
		
	}
	

	@PostMapping("/cad-funcionario")
	public String processaFormularioFuncionario(Funcionario funcionario) throws SQLException {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.inserir(funcionario);
		return "redirect:/ger-funcionarios";
		
	}
	
	@GetMapping("/excluir-funcionario")
	public String deletar(@RequestParam("cod_func") int i) {
		funcionarioDAO.deletar(i);
		return "redirect:/ger-funcionarios";
	}
	
	@RequestMapping("/ger-funcionarios")
	public String clienteTabelaFuncionarios(Model modelo) {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "ger-funcionarios";
		
	}

	@RequestMapping("/edit-funcionario")
	public String exibeFormEditFuncionario(@RequestParam("cod_func") int i, Model modelo) {
		Funcionario func = funcionarioDAO.buscaPorId(i);
		List<Estado> estados = outrosDAO.todos();
		List<CargaHoraria> carga = outrosDAO.todosCarga();
		List<Cargo> cargo = outrosDAO.todosCargo();
		List<DiasTrabalho> dias = outrosDAO.todosDiasTrabalho();
		modelo.addAttribute("func", func);
		modelo.addAttribute("listaDeEstados", estados);
		modelo.addAttribute("listaDeCargos", cargo);
		modelo.addAttribute("listaDeCargaHoraria", carga);
		modelo.addAttribute("listaDeDiasTrab", dias);
		return "edit-funcionario";
	}
	
	@PostMapping("/editar-funcionario")
	public String processaFormularioEditFuncionario(Funcionario funcionario) throws SQLException {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.atualizar(funcionario);
		return "redirect:/ger-funcionarios";
		
	}
	@RequestMapping("/vis-funcionario")
	public String clienteVerFuncionario(@RequestParam("cod_func") int i, Model model) {
		Funcionario func = funcionarioDAO.buscaPorId(i);
		model.addAttribute("func", func);
		return "vis-funcionario";
		
}
}
