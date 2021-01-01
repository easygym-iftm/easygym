package com.grupo6.easygym.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;

import com.grupo6.easygym.dao.ClienteDAO;
import com.grupo6.easygym.dao.HorarioDAO;
import com.grupo6.easygym.dominio.Cliente;
import com.grupo6.easygym.dominio.Horario;

@Controller
public class EasyGymController {
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/result-busca")
	public String pg19() {
		return "result-busca";
		
	}
	
	
}
