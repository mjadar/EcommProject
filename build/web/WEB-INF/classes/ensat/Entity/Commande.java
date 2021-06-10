/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author moham
 */
@Entity
@Table(name="COMMANDE")
public class Commande implements Serializable{
    @Id
    @GeneratedValue
    private int id_com;
    private int id_user;
    private int id_prod;
    private String libelle;
    private int qte;
    private double prix;

    public Commande(int id_com, int id_user, int id_prod, String libelle, int qte, double prix) {
        this.id_com = id_com;
        this.id_user = id_user;
        this.id_prod = id_prod;
        this.libelle = libelle;
        this.qte = qte;
        this.prix = prix;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
