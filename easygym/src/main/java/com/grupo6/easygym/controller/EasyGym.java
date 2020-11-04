package com.grupo6.easygym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;

@Controller
public class EasyGym {


	
	@RequestMapping("/")
	public String inicio() {
		return "index";
		
	}
	
	@RequestMapping("/clientes")
	public String pg2() {
		return "clientes";
		
	}
	@RequestMapping("/ger-clientes")
	public String pg3() {
		return "ger-clientes";
		
	}
	@RequestMapping("/funcionarios")
	public String pg4() {
		return "funcionarios";
		
	}
	@RequestMapping("/ger-funcionarios")
	public String pg5() {
		return "ger-funcionarios";
		
	}
	@RequestMapping("/planos")
	public String pg6() {
		return "planos";
		
	}
	@RequestMapping("/ger-planos")
	public String pg7() {
		return "ger-planos";
		
	}
	@RequestMapping("/horarios")
	public String pg8() {
		return "horarios";
		
	}
	@RequestMapping("/ger-horarios")
	public String pg9() {
		return "ger-horarios";
		
	}
	@RequestMapping("/financeiro")
	public String pg10() {
		return "financeiro";
		
	}
	@RequestMapping("/edit-cliente")
	public String pg11() {
		return "edit-cliente";
		
	}
	@RequestMapping("/vis-cliente")
	public String pg12() {
		return "vis-cliente";
		
	}
	@RequestMapping("/edit-plano")
	public String pg13() {
		return "edit-plano";
		
	}
	@RequestMapping("/vis-plano")
	public String pg14() {
		return "vis-plano";
		
	}
	@RequestMapping("/edit-horario")
	public String pg15() {
		return "edit-horario";
		
	}
	@RequestMapping("/vis-horario")
	public String pg16() {
		return "vis-horario";
		
	}
	@RequestMapping("/edit-funcionario")
	public String pg17() {
		return "edit-funcionario";
		
	}
	@RequestMapping("/vis-funcionario")
	public String pg18() {
		return "vis-funcionario";
		
	}
	@RequestMapping("/result-busca")
	public String pg19() {
		return "result-busca";
		
	}
}
