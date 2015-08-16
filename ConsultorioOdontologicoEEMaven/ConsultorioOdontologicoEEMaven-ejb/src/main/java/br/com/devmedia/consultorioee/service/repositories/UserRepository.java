package br.com.devmedia.consultorioee.service.repositories;

import br.com.devmedia.consultorioee.entities.Users;
import br.com.devmedia.util.MD5Util;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author senaga
 */
public class UserRepository extends BasicRepository {
    
    private static final long serialVersionUID = 1L;    

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Users getUser(int id) {
        return getEntity(Users.class, id);
    }
    
    public Users setUser(Users usr) {
        return setEntity(usr);
    }    
    
    public Users addUser(Users usr) {
        usr.setUsuPassword(MD5Util.getMd5(usr.getUsuPassword()));
        return addEntity(usr);
    }
    
    public void removeUser(Users usr) {
        removeEntity(usr);
    }
    
    public void setPassword(String newPassword, int idOfUser) {
        String np = MD5Util.getMd5(newPassword);
        Users usr = getUser(idOfUser);
        usr.setUsuPassword(np);
        setUser(usr);
    }
    
    public Users getUserByLoginAndPassword(String login, String password) {
        return getPurePojo(Users.class, "select usr from Users usr where usr.usuLogin = ?1 and usr.usuPassword = ?2", 
                login, 
                MD5Util.getMd5(password));
    }
    
    public List<Users> getUsers() {
        return getPureList(Users.class, "select usr from Users usr");
    }
    
    public List<Users> getUsersByName(String name) {
        return getPureList(Users.class, "select usr from Users usr where usr.usuName like ?1", name+"%");
    }    
}
