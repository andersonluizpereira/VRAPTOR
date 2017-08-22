package br.com.sistema.horas.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
//@ApplicationScoped
public class EntityManagerProducer{
	
	private static EntityManagerProducer instance;
	
	@PersistenceContext
	private static EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory("default");
 
	
	public static synchronized EntityManagerProducer getInstance() {
		if (instance == null) {
			instance = new EntityManagerProducer();
		}
		return instance;
	}
	
	
	@Produces @RequestScoped   
    public EntityManager getEntityManager(){
        return factory.createEntityManager();
   }
    
	public void close(@Disposes EntityManager manager){
        manager.close();
    }
}