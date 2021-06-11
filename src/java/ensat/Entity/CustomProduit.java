/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author moham
 */

public class CustomProduit  implements Serializable{
    private int id_prod;
    private String libelle;
    private String categorie;
    private int qte_comm;
    private int qte;
    private double prix ;
    private String image ;

    public CustomProduit(int id_prod, String libelle, String categorie,int qte, int qte_comm, double prix,String image) {
        this.id_prod = id_prod;
        this.libelle = libelle;
        this.categorie = categorie;
        this.qte_comm = qte_comm;
        this.prix = prix;
        this.qte = qte;
        this.image = image;
    }
    
    public CustomProduit(Produits prod,int qteComm){ 
        this.id_prod = prod.getId_prod();
        this.libelle = prod.getLibelle();
        this.categorie = prod.getCategorie();
        this.qte = prod.getQte();
        this.qte_comm = qteComm;
        this.prix = prod.getPrix();
        this.image = prod.getImage();
    }

    public int getId_prod() {
        return id_prod;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getQte_comm() {
        return qte_comm;
    }

    public void setQte_comm(int qte_comm) {
        this.qte_comm = qte_comm;
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
     
   

    @Override
    public boolean equals(Object obj) {
       if (obj == null)
            return false;
        CustomProduit prod = (CustomProduit) obj;
        return prod.id_prod == this.id_prod ;
    }

    @Override
    public int hashCode() {
        return id_prod; 
    }
    
    
}
