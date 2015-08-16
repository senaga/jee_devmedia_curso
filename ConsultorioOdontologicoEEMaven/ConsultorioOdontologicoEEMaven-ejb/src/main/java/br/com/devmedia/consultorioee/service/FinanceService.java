package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Parcela;
import br.com.devmedia.consultorioee.service.repositories.FinanceRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author senaga
 */
@Stateless
@LocalBean
public class FinanceService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private FinanceRepository financeRepository;
    
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        financeRepository = new FinanceRepository(em);
    }
    
    public Parcela addParcela(Parcela par) {
        return financeRepository.addParcela(par);
    }
    
    public Parcela getParcela(Integer idOfParcela) {
        return financeRepository.getParcela(idOfParcela);
    }
    
    public Parcela setParcela(Parcela par) {
        return financeRepository.setParcela(par);
    }
    
    public void removeParcela(Parcela par) {
        financeRepository.removeParcela(par);
    }
    
    public List<Parcela> getParcelasByOrcamento(int orcamentoId) {
        return financeRepository.getParcelasOfOrcamento(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfOrcamentoPagas(int orcamentoId) {
        return financeRepository.getParcelasOfOrcamentoPagas(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfOrcamentoEmAberto(int orcamentoId) {
        return financeRepository.getParcelasOfOrcamentoEmAberto(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfCustomer(int customerId) {
        return financeRepository.getParcelasOfCustomer(customerId);
    }
    
    public List<Parcela> getParcelasOfCustomerPagas(int orcamentoId) {
        return financeRepository.getParcelasOfCustomerPagas(orcamentoId);
    }
    
    public List<Parcela> getParcelasOfCustomerEmAberto(int orcamentoId) {
        return financeRepository.getParcelasOfCustomerEmAberto(orcamentoId);
    }
    
    public Parcela setPagamentoParcela(int idOfParcela) {
        return financeRepository.setPagamentoParcela(idOfParcela);
    }    
}
