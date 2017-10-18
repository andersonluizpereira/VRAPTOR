package br.com.sistema.horas.Presentation;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.sistema.horas.CrossCuting.Security.Open;
import br.com.sistema.horas.CrossCuting.Security.UsuarioLogado;
import br.com.sistema.horas.Domain.Usuario;
import br.com.sistema.horas.Repository.UsuarioRespository;

@Controller
public class LoginController {
    private UsuarioLogado usuarioLogado;
    private UsuarioRespository usuarioDao;
    private Validator validator;
    private Result result;
    @Inject
    public LoginController(UsuarioLogado usuarioLogado, UsuarioRespository usuarioDao,
            Validator validator, Result result) {
        this.usuarioLogado = usuarioLogado;
        this.usuarioDao = usuarioDao;
        this.validator = validator;
        this.result = result;
    }
    public LoginController() {
    }
    
    @Open
    public void form(){}
    
    @Open
    public void autentica(String login, String senha){
    	
    	try {
    		Usuario usuario = usuarioDao.search(login, senha);
            if(usuario != null){
                usuarioLogado.fazLogin(usuario);
                result.redirectTo(UsuarioController.class).lista();
            }	
		} catch (Exception e) {
		        validator.add(new SimpleMessage("login_invalido", "Login ou senha incorretos"));
	            validator.onErrorRedirectTo(this).form();
	       
		}
       
    }
    
    @Open
    public void desloga(){
        usuarioLogado.desloga();
        result.redirectTo(this).form();
    }
}