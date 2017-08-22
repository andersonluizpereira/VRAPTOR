package br.com.sistema.horas.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.sistema.horas.dao.UsuarioDao;
import br.com.sistema.horas.modelos.Usuario;

@Controller
public class UsuarioController{
    private Result result;
    @Inject
    private UsuarioDao usuarioDAO;
    private Validator validator;
    public UsuarioController(){}
    

	
	

    @Inject
    public UsuarioController(Result result, UsuarioDao usuarioDAO, Validator validator){
        this.result = result;
        this.usuarioDAO = usuarioDAO;
        this.validator = validator;
    }
    
   @Get
    public void form(){}
    
    @IncludeParameters
    @Post
    public void adiciona(@Valid Usuario usuario){
        validator.onErrorRedirectTo(this).form();
        usuarioDAO.save(usuario);
        result.redirectTo(this).lista();
    }
    

    @Post
    public void alterar(Usuario usuario){
     
    	Usuario usr = new Usuario();
    	usr.setEmail(usuario.getEmail());
    	usr.setId(usuario.getId());
    	usr.setLogin(usuario.getLogin());
    	usr.setNome(usuario.getNome());
    	usr.setSenha(usuario.getSenha());
    	usuarioDAO.update(usr);
      
        result.redirectTo(this).lista();
    }
    
    @Get
    public void lista(){
        result.include("usuarios", usuarioDAO.findAll());
    }
    
   
    public void buscar(int id){
    	result.include("usuariosed", usuarioDAO.findById(id));
    }
    
}