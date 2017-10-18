package br.com.sistema.horas.Presentation;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.sistema.horas.CrossCuting.Security.UsuarioLogado;
import br.com.sistema.horas.Domain.HoraLancada;
import br.com.sistema.horas.Domain.RelatorioDeHoras;
import br.com.sistema.horas.Repository.HoraLancadaRespository;

@Controller 
public class HoraLancadaController {
   
	private HoraLancadaRespository dao;
	private Validator validator;
	private Result result;
	private UsuarioLogado usuarioLogado;
    
	@Inject
	public HoraLancadaController(HoraLancadaRespository dao, Validator validator, Result result, 
			UsuarioLogado usuarioLogado){
				this.dao = dao;
				this.validator = validator;
				this.result = result;
				this.usuarioLogado = usuarioLogado;
				}
 
	public HoraLancadaController(){}
	
	public void form(){}
	
	public void adiciona(@Valid HoraLancada horaLancada){
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsurio(usuarioLogado.getUsuario());
		dao.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}

	public void lista(){
		result.include("horass", dao.lista());
	}
	
	public void relatorioDeHoras(){
        List<HoraLancada> horas = dao.horasDoUsuario(usuarioLogado.getUsuario());
        RelatorioDeHoras relatorioDeHoras = new RelatorioDeHoras(horas);
        result.include("relatorio", relatorioDeHoras);
	}
	
}

           