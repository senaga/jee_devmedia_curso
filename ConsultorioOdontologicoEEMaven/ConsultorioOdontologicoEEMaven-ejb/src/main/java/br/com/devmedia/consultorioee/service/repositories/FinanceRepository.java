package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.entities.Parcela;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author senaga
 */
public class FinanceRepository extends BasicRepository {
    
    private static final long serialVersionUID = 1L;

    public FinanceRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Parcela getParcela(int id) {
        return getEntity(Parcela.class, id);
    }    
    
    public Parcela setParcela(Parcela entity) {
        return setEntity(entity);
    } 
    
    public Parcela addParcela(Parcela entity) {
        return addEntity(entity);
    } 
    
    public void removeParcela(Parcela entity) {
        removeEntity(entity);
    }
    
    public List<Parcela> getParcelasOfOrcamento(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.orcId = ?1",
                idOfOrcamento);
    }    
    
    public List<Parcela> getParcelasOfOrcamentoEmAberto(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = ?2", 
                idOfOrcamento,
                Boolean.FALSE);
    }
    
    public List<Parcela> getParcelasOfOrcamentoPagas(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.orcId = ?1 and par.parPago = ?2", 
                idOfOrcamento,
                Boolean.TRUE);
    }    
    
    public List<Parcela> getParcelasOfCustomer(int idOfCustomer) {
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.orcCustomer.cusId = ?1",
                idOfCustomer);
    }    
    
    public List<Parcela> getParcelasOfCustomerEmAberto(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.orcCustomer.cusId = ?1 and par.parPago = ?2", 
                idOfOrcamento,
                Boolean.FALSE);
    }
    
    public List<Parcela> getParcelasOfCustomerPagas(int idOfOrcamento) {
        return getPureList(Parcela.class, "select par from Parcela par where par.parOrcamento.orcCustomer.cusId = ?1 and par.parPago = ?2", 
                idOfOrcamento,
                Boolean.TRUE);
    }    
    
    public Parcela setPagamentoParcela(int idOfParcela) {
        Parcela par = getParcela(idOfParcela);
        par.setParPago(true);
        return setParcela(par);        
    }    
}
