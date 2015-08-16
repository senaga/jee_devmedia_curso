package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.entities.Orcamentoitem;
import br.com.devmedia.consultorioee.service.repositories.OrcamentoRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author senaga
 */
@Stateless
@LocalBean
public class OrcamentoService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private OrcamentoRepository orcamentoRepository;
    
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        orcamentoRepository =  new OrcamentoRepository(em);
    }
    
    public Orcamento addOrcamento(Orcamento orc) {
        return orcamentoRepository.addOrcamento(orc);
    }
    
    public Orcamento setOrcamento(Orcamento orc) {
        return orcamentoRepository.setOrcamento(orc);
    }
    
    public Orcamento getOrcamento(Integer idOfOrcamento) {
        return orcamentoRepository.getOrcamento(idOfOrcamento);
    }
    
    public void removeOrcamento(Orcamento orc) {
        orcamentoRepository.removeOrcamento(orc);
    }
    
    public Orcamentoitem addItem(Orcamentoitem item) {
        return orcamentoRepository.addItem(item);
    }
    
    public Orcamentoitem setItem(Orcamentoitem item) {
        return orcamentoRepository.setItem(item);
    }
    
    public Orcamentoitem getItem(Integer idOfItem) {
        return orcamentoRepository.getItem(idOfItem);
    }
    
    public List<Orcamento> getOrcamentos(Integer idofCustomer) {
        return orcamentoRepository.getOrcamentos(idofCustomer);
    }
    
    public List<Orcamentoitem> getItens(Integer idOfOrcamento) {
        return orcamentoRepository.getItens(idOfOrcamento);
    }    
}
