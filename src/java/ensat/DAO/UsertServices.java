package ensat.DAO;

import ensat.Entity.Usert;
import ensat.Entity.Usert;
import java.util.List;
import org.hibernate.Session;



public class UsertServices implements interfaceDAO<Usert>{

    private Session s;
   
    
    public  boolean creer(Usert p) {
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
    public boolean update(Usert p) {
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
    public boolean delete(int id_user) {
        try{
          hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          s.delete(id_user);
          s.getTransaction().commit();
          return true;
        }catch(Exception e){
            e.printStackTrace();
             return false;
        }
    }

    @Override
    public Usert recuperer(int id_user) {
        Usert resultat = null;
        try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          resultat = (Usert) s.get(Usert.class, id_user);
          s.getTransaction().commit();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return resultat;
    }

    @Override
    public List<Usert> recuperer_All() {
       List<Usert> list_users= null; 
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
       
           list_users = s.createCriteria(Usert.class).list();

          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
       return list_users;
    }
    
    public Boolean Verifier_login(String email,String password){
        List<Usert> list_users;
        Boolean flag=false;
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          list_users = s.getNamedQuery("findByEmailMdp")
                        .setParameter("email", email)
                        .setParameter("mdp", password).list();
          if(list_users.size() != 0){
              flag= true;
          }else{
              System.out.println("????????????????????????????????????????????????????? wa khawya");
          }
          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
       return flag;
    }
    
    //permet de verifier sil'email existe deja dans la base de donnee
    public Boolean Verifier_Email(String email){
          List<Usert> list_users;
        Boolean flag=false;
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          list_users = s.getNamedQuery("findByEmail")
                        .setParameter("email", email)
                        .list(); 
          if(list_users.size() != 0){
              flag= true;
          }
          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
       return flag;
    }
      public Usert recuperer_By_email(String email){
          List<Usert> list_users=null;
       try{
          s = hibernateCurrentSession.getSessionFactory().openSession();
          s.beginTransaction();
          list_users = s.getNamedQuery("findByEmail")
                        .setParameter("email", email)
                        .list();
          s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
           if(list_users.size() != 0){
              return list_users.get(0);
          }
           return null;
    }
    
}
