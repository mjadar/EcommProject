/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author moham
 */

@Entity
@Table(name="COMMANDE")
public class Commande implements Serializable{
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_com;
    @ManyToOne
     @JoinColumn(name = "id_user")
    private Usert user;
    @ManyToOne
     @JoinColumn(name = "id_prod")
    private Produits produit;
    private int qte ;
    private double prix;

    public Commande() {
    }

    public Commande(Usert user, Produits produit, double prix,int qte) {
        this.user = user;
        this.produit = produit;
        this.prix = prix;
    }  

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public Usert getUser() {
        return user;
    }

    public void setUser(Usert user) {
        this.user = user;
    }

    public Produits getProduit() {
        return produit;
    }

    public void setProduit(Produits produit) {
        this.produit = produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    
    
}
