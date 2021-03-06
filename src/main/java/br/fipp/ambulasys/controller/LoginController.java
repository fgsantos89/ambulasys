/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.repository.Pessoas;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felipe
 */
@Named
@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
    
    @EJB
    private Pessoas pessoas;
    
    private String login;
    private String senha;

    public LoginController() {
        login = "";
        senha = "";
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String validarUsuario() {
        boolean valido = pessoas.validar(login, senha);
        HttpSession session =  getSession();
        session.setAttribute("logado", valido);
        if (!valido) {
           FacesContext.getCurrentInstance().addMessage(
                    "msg",
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Usuario ou senha invalida",
                            "Por favor, tente novamente."));
           return "login";
        } else {
           return "restrito/gerenciamento/mathospitalar?redirect-true";
        }
    }
    
    public void logoff(){
        HttpSession session =  getSession();
        session.invalidate();
    }

    private HttpSession getSession() {
        HttpSession session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return session;
    }
}
