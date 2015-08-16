package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Anaminese;
import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.entities.Orcamento;
import br.com.devmedia.consultorioee.service.repositories.AnamineseRepository;
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
public class AnamineseService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private AnamineseRepository anamineseRepository;
    

    @PostActivate
    @PostConstruct
    private void postConstruct() {
        anamineseRepository = new AnamineseRepository(em);
    }
    
    public Anaminese getAnaminese(Integer idOfAnamnese) {
        return anamineseRepository.getAnaminese(idOfAnamnese);
    }
    
    public Anaminese addAnaminese(Anaminese an) {
        return anamineseRepository.addAnaminese(an);
    }
    
    public Anaminese setAnaminese(Anaminese an) {
        return anamineseRepository.setAnaminese(an);
    }
    
    public void removeAnaminese(Anaminese an) {
        anamineseRepository.removeAnaminese(an);
    }
    
    public List<Anaminese> getAnaminesesByCustomer(Customer customer) {
        return anamineseRepository.getAnaminesesByCustomer(customer);
    }
    
    public List<Anaminese> getAnaminesesByOrcamento(Orcamento orc) {
        return anamineseRepository.getAnaminesesByOrcamento(orc);
    }    
}
