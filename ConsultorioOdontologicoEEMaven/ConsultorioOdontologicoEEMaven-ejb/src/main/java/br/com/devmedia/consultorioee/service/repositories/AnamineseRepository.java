package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.entities.Anaminese;
import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.entities.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author senaga
 */
public class AnamineseRepository extends BasicRepository {
    
    private static final long serialVersionUID = 1L;

    public AnamineseRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Anaminese addAnaminese(Anaminese entity) {
        return addEntity(entity);
    }    
        
    public Anaminese setAnaminese(Anaminese entity) {
        return setEntity(entity);
    }     
    
    public void removeAnaminese(Anaminese entity) {
        removeEntity(entity);
    }
    
    public Anaminese getAnaminese(int id) {
        return getEntity(Anaminese.class, id);
    }
    
    public List<Anaminese> getAnaminesesByCustomer(Customer customer) {
        return getPureList(Anaminese.class, "select ans from Anaminese ans.ansCustomer.cusId = ?1",
                customer.getCusId());
    }            
    
    public List<Anaminese> getAnaminesesByOrcamento(Orcamento orcamento) {
        return getPureList(Anaminese.class, "select ans from Anaminese ans.ansOrcamento.orcId = ?1",
                orcamento.getOrcId());
    }            
    
}
