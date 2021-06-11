/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Control;

import ensat.DAO.ProduitServices;
import ensat.DAO.UsertServices;
import ensat.Entity.Usert;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

/**
 *
 * @author moham
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @NotNull(message = "email can't be empty") 
    private String email_login;
    @NotNull(message = "mdp can't be empty") 
    private String mdp_login;
    private Boolean isLogged=false;
    private String msg="";
    
    
    public LoginBean() {
    }

    public String getEmail_login() {
        return email_login;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setEmail_login(String email_login) {
        this.email_login = email_login;
    }

    public String getMdp_login() {
        return mdp_login;
    }

    public void setMdp_login(String mdp_login) {
        this.mdp_login = mdp_login;
    }

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    public void login() {
        try{
             UsertServices us = new UsertServices();
             if(us.Verifier_login(email_login, mdp_login)){
                 isLogged = true;
                   msg="";
                 FacesContext.getCurrentInstance().getExternalContext()
                                    .redirect("index.xhtml");
             }else{
                 isLogged = false;
                 msg = "inorrect login/password";
             }
        }catch(IOException e){
            System.out.println("error login"+e);
        }
         
    }
    
    
}
