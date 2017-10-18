package br.com.sistema.horas.Application;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.sistema.horas.Domain.Usuario;
import br.com.sistema.horas.Repository.UsuarioRespository;

public class UsuarioApplication {
	    @Inject
	    private UsuarioRespository usuarioDAO;
	    
	    @Inject
	    public UsuarioApplication(UsuarioRespository usuarioDAO){
	       
	        this.usuarioDAO = usuarioDAO;
	       
	    } 
	    
	    
	    public void Salvar(Usuario usr){
	    	
	    try {
			usuarioDAO.save(usr);
		} catch (Exception e) {
			// TODO: handle exception
		}	
	    }
	    
        public void Alterar(Usuario usr){
	    	try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    }
        
        
        public void Deletar(Usuario usr){
	    	try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    }
	    
//	    public IList<Usuario> listar(){
//	    	
//	    	
//	    	
//	    	return IList<null>();
//	    }
	    
}
