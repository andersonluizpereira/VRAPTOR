package br.com.sistema.horas.bll;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.sistema.horas.dao.UsuarioDao;
import br.com.sistema.horas.modelos.Usuario;

public class UsuarioBll {
	    @Inject
	    private UsuarioDao usuarioDAO;
	    
	    @Inject
	    public UsuarioBll(UsuarioDao usuarioDAO){
	       
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
