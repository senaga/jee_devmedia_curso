package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Customer;
import br.com.devmedia.consultorioee.service.repositories.CustomerRepository;
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
public class CustomerService extends BasicService {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    private CustomerRepository customerRepository;
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        customerRepository = new CustomerRepository(em);
    }
    
    public Customer addCustomer(Customer cus) {
        return customerRepository.addCustomer(cus);
    }
    
    public Customer setCustomer(Customer cus) {
        return customerRepository.setCustomer(cus);
    }
    
    public void removeCustomer(Customer cus) {
        customerRepository.removeCustomer(cus);
    }
    
    public Customer getCustomer(int idOfCustomer)  {
        return customerRepository.getCustomer(idOfCustomer);
    }
    
    public List<Customer> getCustomerByName(String nameOfCustomer) {
        return customerRepository.getCustomersByName(nameOfCustomer);
    }
    
    public List<Customer> getCustomersToCall(int month,int year) {
        return customerRepository.getCustomersToCall(month, year);
    }
    
    public List<Customer> getCustomersComPagamentoEmAberto() {
        return customerRepository.getCustomersComPagamentoEmAberto();
    }
}