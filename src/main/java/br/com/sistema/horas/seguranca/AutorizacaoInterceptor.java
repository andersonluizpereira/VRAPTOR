package br.com.sistema.horas.seguranca;

import java.lang.annotation.Annotation;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.sistema.horas.controllers.LoginController;


@Intercepts
public class AutorizacaoInterceptor {
    private ControllerMethod method;
    private UsuarioLogado usuarioLogado;
    private Result result;
    public AutorizacaoInterceptor(){}
    @Inject
    public AutorizacaoInterceptor(ControllerMethod method, UsuarioLogado usuarioLogado, Result result){
        this.method = method;
        this.usuarioLogado = usuarioLogado;
        this.result = result;
    }

    @Accepts
    public boolean accpet(){
    return !method.containsAnnotation(Open.class);
    	
    }
    
    @AroundCall
    public void intercept(SimpleInterceptorStack stack){
        if(usuarioLogado.isLogado()){
            stack.next();
        }else{
            result.redirectTo(LoginController.class).form();
        }
    }
}