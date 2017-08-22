package br.com.sistema.horas.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Patch;

@Controller
public class IndexController {

	@Patch("/")
	public void Index(){}
	
	
}
