package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Users;
import br.com.devmedia.consultorioee.service.repositories.UserRepository;
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
public class UserService extends BasicService {
    
    private static final long serialVersionUID = 1L;    
    
    @PersistenceContext
    private EntityManager em;
    private UserRepository userRepository;

    public UserService() {
    }
    
    public Users getUser(int id) {
        return userRepository.getUser(id);
    }
    
    public Users setUser(Users user) {
        return userRepository.setUser(user);
    }
    
    public void removeUser(Users user) {
        userRepository.removeUser(user);
    }
    
    public void setPassword(int idOfUser, String password) {
        userRepository.setPassword(password, idOfUser);
    }
    
    public Users addUser(Users user) {
        return userRepository.addUser(user);
    }
    
    public Users getUserByLoginAndPassword(String login, String password) {
        return userRepository.getUserByLoginAndPassword(login, password);
    }
    
    public List<Users> getUsers() {
        return userRepository.getUsers();
    }
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        userRepository = new UserRepository(em);
    }    
}
