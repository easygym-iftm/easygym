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
}
