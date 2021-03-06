package br.com.sistema.horas.CrossCuting.Security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.sistema.horas.Domain.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable{
    private Usuario usuario;
    public void fazLogin(Usuario usuario){
        this.usuario = usuario;
    }
    public void desloga(){
        this.usuario = null;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    public boolean isLogado() {
        return this.usuario != null;
    }
}