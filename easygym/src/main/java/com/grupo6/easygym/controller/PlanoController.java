package com.grupo6.easygym.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo6.easygym.dao.HorarioDAO;
import com.grupo6.easygym.dao.PlanoDAO;
import com.grupo6.easygym.dominio.Horario;
import com.grupo6.easygym.dominio.Plano;

@Controller
public class PlanoController {
	private PlanoDAO planoDAO;
	private HorarioDAO horarioDAO;
	
	public PlanoController() {
		super();
		planoDAO = new PlanoDAO();
		horarioDAO = new HorarioDAO();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/vis-plano")
		public String clienteVerPlano(@RequestParam("cod_plano") int i, Model model) {
			Plano plano = planoDAO.buscaPorId(i);
			model.addAttribute("plano", plano);
			return "vis-plano";
			
	}
	
	@RequestMapping("/planos")
	public String mostrarFormularioPlano(Model modelo) {
		Plano plano = new Plano();
		List<Horario> lista = horarioDAO.todos();
		modelo.addAttribute("plano", plano);
		modelo.addAttribute("listaDeHorarios", lista);
		return "planos";
		
	}
	

	@PostMapping("/cad-plano")
	public String processaFormularioPlano(Plano plano) throws SQLException {
		PlanoDAO dao = new PlanoDAO();
		dao.inserir(plano);
		return "redirect:/ger-planos";
		
	}
	
	@RequestMapping("/ger-planos")
	public String clienteTabelaPlanos(Model modelo) {
		PlanoDAO dao = new PlanoDAO();
		List<Plano> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "ger-planos";
	}
	
	@GetMapping("/excluir-plano")
	public String deletar(@RequestParam("cod_plano") int i) {
		planoDAO.deletar(i);
		return "redirect:/ger-planos";
	}
	
	@RequestMapping("/edit-plano")
	public String exibeFormEditPlano(@RequestParam("cod_plano") int i, Model model) {
		Plano plano = planoDAO.buscaPorId(i);
		List<Horario> lista = horarioDAO.todos();
		model.addAttribute("plano", plano);
		model.addAttribute("listaDeHorarios", lista);
		return "edit-plano";
	}
	
	@PostMapping("/editar-plano")
	public String processaFormularioEditPlano(Plano plano) throws SQLException {
		PlanoDAO dao = new PlanoDAO();
		dao.atualizar(plano);
		return "redirect:/ger-planos";
		
	}
	
}
