/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Control;

import com.sun.xml.rpc.processor.ProcessorException;
import ensat.DAO.CommandeServices;
import ensat.DAO.ProduitServices;
import ensat.DAO.UsertServices;
import ensat.Entity.Commande;
import ensat.Entity.CustomProduit;
import ensat.Entity.Produits;
import ensat.Entity.Usert;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author moham
 */
@Named(value = "panierBean")
@SessionScoped
public class PanierBean implements Serializable {
    private String email_log;
    private double total;
  //  private Set<Produits> produits_panier= new HashSet<Produits>();
    private List<CustomProduit> produits_panier= new ArrayList<CustomProduit>();
    private int qte_com;
   
    public PanierBean() {
        if(produits_panier!= null){
            getProduits_panier();
            calculerTotal();
        }     
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEmail_log() {
        return email_log;
    }

    public void setEmail_log(String email_log) {
        this.email_log = email_log;
    }


    public List<CustomProduit> getProduits_panier() {
        return produits_panier;
    }

    public void setProduits_panier(List<CustomProduit> produits_panier) {
        this.produits_panier = produits_panier;
    }
    
    public int getQte_com() {
        return qte_com;
    }

    public void setQte_com(int qte_com) {
        this.qte_com = qte_com;
    }
    
    public void ajouter_panier(Produits prod,int qtecom){
       CustomProduit cp = new CustomProduit(prod,qtecom);
        System.out.println("produit "+ prod.getLibelle()+" - "+prod.getCategorie() +" - "  );
        if(prod != null && !produits_panier.contains(cp) ){
             produits_panier.add(cp);
        }
        calculerTotal();
    }
    
    
    public int getQteCmd_By_ID(int id_prod){
        int qt;
        for(CustomProduit cp : produits_panier){
            if(cp.getId_prod() == id_prod){
               return cp.getQte_comm();
            }
        }
        return 0;
    }
    
    public void increase(int id_prod){
        int qt;
        for(CustomProduit cp : produits_panier){
            if(cp.getId_prod() == id_prod){
                qt = cp.getQte_comm();
                if(qt<cp.getQte()){
                    cp.setQte_comm(++qt);
                    return;
                }
             
            }
        }
        calculerTotal();
    }
    
     public void decrease(int id_prod){
        int qt;
        for(CustomProduit cp : produits_panier){
            if(cp.getId_prod() == id_prod){
                qt = cp.getQte_comm();
                if(qt>1){
                    cp.setQte_comm(--qt);
                }
            }
        }
        calculerTotal();
    }
    
    public void calculerTotal(){
        total = 0;
       for(CustomProduit cp : produits_panier){
           total += cp.getPrix() * cp.getQte_comm();
         
       }
    }
    
    public void confirmerPanier(String email){
        UsertServices us = new UsertServices();
        ProduitServices ps = new ProduitServices();
        CommandeServices cs = new CommandeServices();
        Usert user = us.recuperer_By_email(email);
        Commande cm;
       
        for(CustomProduit cp : produits_panier){
             Produits p = new Produits();
             p.setId_prod(cp.getId_prod());
             p.setLibelle(cp.getLibelle());
             p.setImage(cp.getImage());
             p.setPrix(cp.getPrix());
             p.setQte(cp.getQte());
             p.setCategorie(cp.getCategorie());
            cm = new Commande(user,p,cp.getPrix()*cp.getQte_comm(),cp.getQte_comm());
            cs.creer(cm);
        }
    }
}
