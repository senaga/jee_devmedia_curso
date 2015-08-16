package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author senaga
 */
public class OrcamentoRepository extends BasicRepository {
    
    private static final long serialVersionUID = 1L;    

    public OrcamentoRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Orcamento addOrcamento(Orcamento entity) {
        return addEntity(entity);
    }    
        
    public Orcamento setOrcamento(Orcamento entity) {
        return setEntity(entity);
    }     
    
    public void removeOrcamento(Orcamento entity) {
        removeEntity(entity);
    }
    
    public Orcamento getOrcamento(int id) {
        return getEntity(Orcamento.class, id);
    }
    
    public void removeItem(Orcamentoitem entity) {
        removeEntity(entity);
    }    
    
    public Orcamentoitem addItem(Orcamentoitem entity) {
        return addEntity(entity);
    }
    
    public Orcamentoitem setItem(Orcamentoitem entity) {
        return setEntity(entity);
    }    
    
    public Orcamentoitem getItem(int idOfOrcamentoItem) {
        return getEntity(Orcamentoitem.class, idOfOrcamentoItem);
    }    
    
    public List<Orcamentoitem> getItens(int idOfOrcamento) {
        return getPureList(Orcamentoitem.class, "select ori from Orcamentoitem ori where ori.oriOrcamento.orcId = ?1",
                idOfOrcamento);        
    }    
    
    public List<Orcamento> getOrcamentos(int idOfCustomer) {
        return getPureList(Orcamento.class, "select orc from Orcamento orc where orc.orcCustomer.cusId = ?1",
                idOfCustomer);
    }        
}
