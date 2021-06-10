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
@Table(name="Produits")
public class Produits  implements Serializable{
    @Id
    @GeneratedValue
    private int id_prod;
    private String libelle;
    private String categorie;
    private int qte;
    private double prix;
    private String image;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Produits(int id_prod, String libelle, double prix) {
        this.id_prod = id_prod;
        this.libelle = libelle;
        this.prix = prix;
    }

    public Produits() {
    }

    public Produits(int id_prod, String libelle, String categorie, int qte, double prix, String image) {
        this.id_prod = id_prod;
        this.libelle = libelle;
        this.categorie = categorie;
        this.qte = qte;
        this.prix = prix;
        this.image = image;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
