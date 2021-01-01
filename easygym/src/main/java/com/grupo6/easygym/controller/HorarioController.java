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
import com.grupo6.easygym.dao.HorarioDAO;
import com.grupo6.easygym.dominio.Cliente;
import com.grupo6.easygym.dominio.Horario;

@Controller
public class HorarioController {
	private HorarioDAO horarioDAO;
	
	
	
	public HorarioController() {
		super();
		horarioDAO = new HorarioDAO();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/horarios")
	public String mostrarFormularioHorario(Model modelo) {
		modelo.addAttribute("horario", new Horario());
		return "horarios";
		
	}
	
	@GetMapping("/excluir")
	public String deletar(@RequestParam("cod_horario") int i) {
		horarioDAO.deletar(i);
		return "redirect:/ger-horarios";
	}
	
	@PostMapping("/cad-horario")
	public String processaFormularioHorario(Horario horario) throws SQLException {
		HorarioDAO dao = new HorarioDAO();
		dao.inserir(horario);
		return "redirect:/vis-horario";
		
	}
	@RequestMapping("/ger-horarios")
	public String clienteTabelaHorario(Model modelo) {
		HorarioDAO dao = new HorarioDAO();
		List<Horario> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "ger-horarios";
		
	}
	
	@RequestMapping("/edit-horario")
	public String exibeFormEditCliente(@RequestParam("cod_horario") int i, Model model) {
		Horario horario = horarioDAO.buscaPorId(i);
		model.addAttribute("horario", horario);
		return "edit-horario";
	}
	
	@PostMapping("/editar-horario")
	public String processaFormularioEditHorario(Horario horario) throws SQLException {
		HorarioDAO dao = new HorarioDAO();
		dao.atualizar(horario);
		return "redirect:/ger-horarios";
		
	}
	
	@RequestMapping("/vis-horario")
	public String clienteVerHorario(@RequestParam("cod_horario") int i, Model model) {
		Horario horario = horarioDAO.buscaPorId(i);
		model.addAttribute("horario", horario);
		return "vis-horario";
		
	}
}
