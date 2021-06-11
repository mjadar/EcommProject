/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat.DAO;

import ensat.Entity.Commande;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author moham
 */
public class CommandeServices implements interfaceDAO<Commande>{

    private Session s;
   
    
    public  boolean creer(Commande p) {
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
    public boolean update(Commande p) {
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
    public boolean delete(int id_com) {
        try{
          hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.delete(id_com);
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
    }

    @Override
    public Commande recuperer(int id_com) {
        Commande resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Commande) s.get(Commande.class, id_com);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

    @Override
    public List<Commande> recuperer_All() {
       List<Commande> list_com= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          list_com = s.createCriteria(Commande.class).list();
          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
       return list_com;
    }
    
}