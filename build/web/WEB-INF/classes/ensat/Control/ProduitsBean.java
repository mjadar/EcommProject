/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.Control;

import ensat.DAO.ProduitServices;
import ensat.Entity.Produits;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author moham
 */
@Named(value = "produitsBean")
@SessionScoped
public class ProduitsBean implements Serializable {

    /**
     * Creates a new instance of ProduitsBean
     */
    private int id_prod;
    private String libelle;
    private String categorie;
    private double prix;
    private int qte;
    private String image;
    private List<Produits> list_produits;
    
    public ProduitsBean() {
        getProducts();
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
  

    public List<Produits> getList_produits() {
        return list_produits;
    }

    public void setList_produits(List<Produits> list_produits) {
        this.list_produits = list_produits;
    }
    
      
    public void saveProducts(){
        Produits p = new Produits(id_prod,libelle,categorie,qte,prix,image);
        ProduitServices ps = new ProduitServices();
        boolean b = ps.creer(p);
        list_produits = ps.recuperer_All();
        
    }
    
      public void getProducts(){
         ProduitServices ps = new ProduitServices();
         list_produits = ps.recuperer_All(); 
    }
}
