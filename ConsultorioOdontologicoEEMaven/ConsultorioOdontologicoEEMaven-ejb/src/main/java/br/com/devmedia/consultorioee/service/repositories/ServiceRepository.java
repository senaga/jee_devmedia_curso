package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.entities.Service;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author senaga
 */
public class ServiceRepository extends BasicRepository {
    
    private static final long serialVersionUID = 1L;

    public ServiceRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Service addService(Service entity) {
        return addEntity(entity);
    }    
        
    public Service setService(Service entity) {
        return setEntity(entity);
    }     
    
    public void removeService(Service entity) {
        removeEntity(entity);
    }
    
    public Service getService(int id) {
        return getEntity(Service.class, id);
    }
    
    public List<Service> getServices() {
        return getPureList(Service.class, "select srv from Service srv");
    }    
        
    public List<Service> getServicesByName(String name) {
        return getPureList(Service.class, "select srv from Service srv where srv.srvName like ?1", name+"%");
    }      
}
