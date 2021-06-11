/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Control;

import ensat.DAO.ProduitServices;
import ensat.DAO.UsertServices;
import ensat.Entity.Usert;
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
@Named(value = "usertBean")
@SessionScoped
public class UsertBean implements Serializable {

    @NotNull(message = "Name can't be empty") 
    private String email;
    @NotNull(message = "Name can't be empty") 
    private String mdp;
    @NotNull(message = "Name can't be empty") 
    private String nom;
    @NotNull(message = "Name can't be empty") 
    private String prenom;

    public UsertBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    private void clearFields(){
        nom="";
        prenom="";
        email="";
        mdp="";
    }
    
    public void register(){
          
        Usert user = new Usert(nom,prenom,email,mdp);
        UsertServices ps = new UsertServices();
        if(!ps.Verifier_Email(email)){
             boolean b = ps.creer(user);
             clearFields();
             FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
             FacesContext.getCurrentInstance().addMessage( null, message );
        }else{
            FacesMessage message = new FacesMessage( "Echec de l'inscription email existe deja !" );
            FacesContext.getCurrentInstance().addMessage( null, message );
        }
    }
    
}
