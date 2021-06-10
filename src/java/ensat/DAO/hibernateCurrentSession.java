package ensat.DAO;

 import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class hibernateCurrentSession {
    private static SessionFactory sessionFactory = getSessionFactory();

    

   public static SessionFactory getSessionFactory() throws HibernateException {
      
       Configuration configuration = new Configuration().configure();
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
      
       /* if(sessionFactory == null){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
       serviceRegistry = 
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);}*/
       
        return sessionFactory;
    }

   public static Session openSession(){
       return sessionFactory.openSession();
   }
   
   public static Session getCurrentSession(){
       return sessionFactory.getCurrentSession();
   }
   
   public static void close(){
       if(sessionFactory != null){
           sessionFactory.close();
       }
       sessionFactory = null;
   }
    
}
