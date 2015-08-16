package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.entities.Customer;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author senaga
 */
public class CustomerRepository extends BasicRepository {
    
    private static final long serialVersionUID = 1L;

    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Customer addCustomer(Customer entity) {
        return addEntity(entity);
    }    
        
    public Customer setCustomer(Customer entity) {
        return setEntity(entity);
    }     
    
    public void removeCustomer(Customer entity) {
        removeEntity(entity);
    }
    
    public Customer getCustomer(int id) {
        return getEntity(Customer.class, id);
    }
    
    public List<Customer> getCustomers() {
        return getPureList(Customer.class, "select cus from Customer cus");
    }    
        
    public List<Customer> getCustomersByName(String name) {
        return getPureList(Customer.class, "select cus from Customer cus where cus.cusName like ?1", name+"%");
    }    
    
    public List<Customer> getCustomersComPagamentoEmAberto() {
        return getPureList(Customer.class, "select par.parOrcamento.orcCustomer from Parcela par where par.parPago = ?1", 
                Boolean.TRUE);
    }    
    
    public List<Customer> getCustomersToCall(int month, int year) {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        final Date dataInicial = cal.getTime();
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        final Date dataFinal = cal.getTime();        
        return getPureList(Customer.class, "select orc.orcCustomer from Orcamento orc where orc.orcDate >= ?1 and "
                + "orc.orcDate <= ?2", dataInicial, dataFinal);
    }      
}
