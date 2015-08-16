package br.com.devmedia.consultorioee.service.repositories;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author senaga
 */
abstract class BasicRepository {
    
    private static final long serialVersionUID = 2L;

    private final EntityManager entityManager;
    
    public BasicRepository(EntityManager entityManager) {
        this.entityManager = entityManager;        
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }    
    
    protected <T> T addEntity(T data) {
        getEntityManager().persist(data);
        return data;
    }
    
    protected <T> T getEntity(Class<T> classToCast, Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }
    
    protected <T> T setEntity(T object) {
        return getEntityManager().merge(object);
    }   
    
    protected void removeEntity(Object object) {
        getEntityManager().remove(merge(object));
    }       
    
    protected <T> List<T> getPureList(Class<T> classToCast, String query, Object... values) {        
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    
    protected <T> T getPurePojo(Class<T> classToCast, String query, Object... values) {        
        Query qr = createQuery(query, values);
        return (T)qr.getSingleResult();
    }
    
    protected int executeQuery(String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }
    
    private Object merge(Object object) {
        return getEntityManager().merge(object); 
    }
    
    private Query createQuery(String query, Object... values) {
        Query qr = getEntityManager().createQuery(query);
        for(int i = 0; i < values.length; i++) {
            qr.setParameter(i+1, values[i]);
        }
        return qr;
    }
}
