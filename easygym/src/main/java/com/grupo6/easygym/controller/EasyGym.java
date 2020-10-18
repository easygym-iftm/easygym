package com.grupo6.easygym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/funcionarios")
	public String pg3() {
		return "funcionarios";
		
	}
	@RequestMapping("/planos")
	public String pg4() {
		return "planos";
		
	}
	@RequestMapping("/horarios")
	public String pg5() {
		return "horarios";
		
	}
	@RequestMapping("/financeiro")
	public String pg6() {
		return "financeiro";
		
	}
}
