/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.DAO;

import ensat.Entity.Produits;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;



public class ProduitServices implements interfaceDAO<Produits>{

    private Session s;
   
    
    public  boolean creer(Produits p) {
        try{
         s = hibernateCurrentSession.getSessionFactory().openSession();
         s.beginTransaction();
          s.save(p);        
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
       
    
    }

    @Override
    public boolean update(Produits p) {
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.update(p);
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
      }

    @Override
    public boolean delete(int id_prod) {
        try{
          hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.delete(id_prod);
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
    }

    @Override
    public Produits recuperer(int id_prod) {
        Produits resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Produits) s.get(Produits.class, id_prod);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

    @Override
    public List<Produits> recuperer_All() {
       List<Produits> list_prod= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
       
          //list_prod =   s.createSQLQuery("select * from PRODUITS").list();//requete SQL
           list_prod = s.createCriteria(Produits.class).list();
        //  list_prod = s.createQuery("from Produits").list();//requete HQL
          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
       return list_prod;
    }
    
    public List<Produits> recuperer_By_Categ(String categ){
          List<Produits> list_prod= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          list_prod = s.getNamedQuery("findByCategory").setParameter("categ", categ).list(); 
          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
       return list_prod;
    }
    
}
