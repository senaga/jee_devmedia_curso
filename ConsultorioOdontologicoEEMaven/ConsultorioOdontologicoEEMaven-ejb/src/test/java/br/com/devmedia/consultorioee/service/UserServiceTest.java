package br.com.devmedia.consultorioee.service;

import br.com.devmedia.consultorioee.entities.Users;
import br.com.devmedia.util.MD5Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author senaga
 */
public class UserServiceTest {
    
    private Users userOne;
    private Users userTwo;
    private Users userThree;     
    private EJBContainer container;
    private UserService instance;
    
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {        
    }
    
    @Before
    public void setUp() throws NamingException {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        
        userOne = new Users();
        userOne.setUsuAdministrator(new Random().nextBoolean());
        userOne.setUsuDentist(new Random().nextBoolean());
        userOne.setUsuLogin("testLoginOne" + new Random().nextInt());
        userOne.setUsuName("testNameOne" + new Random().nextInt());
        userOne.setUsuPassword(userOne.getUsuLogin());
        
        userTwo = new Users();
        userTwo.setUsuAdministrator(new Random().nextBoolean());
        userTwo.setUsuDentist(new Random().nextBoolean());
        userTwo.setUsuLogin("testLoginTwo" + new Random().nextInt());
        userTwo.setUsuName("testNameTwo" + new Random().nextInt());
        userTwo.setUsuPassword(userTwo.getUsuLogin());        
        
        userThree = new Users();
        userThree.setUsuAdministrator(new Random().nextBoolean());
        userThree.setUsuDentist(new Random().nextBoolean());
        userThree.setUsuLogin("testLoginThree" + new Random().nextInt());
        userThree.setUsuName("testNameThree" + new Random().nextInt());
        userThree.setUsuPassword(userThree.getUsuLogin());                
        
        instance = (UserService) container.getContext().lookup("java:global/classes/UserService");        
        
        userOne = instance.addUser(userOne);
        userTwo = instance.addUser(userTwo);
        userThree = instance.addUser(userThree);        
    }
    
    @After
    public void tearDown() {
        instance.removeUser(userOne);
        instance.removeUser(userTwo);
        instance.removeUser(userThree);        
        container.close();
    }

    /**
     * Test of getUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        Users expResult = userTwo;
        Users result = instance.getUser(userTwo.getUsuId());
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetUser() throws Exception {
        System.out.println("setUser");
        Users user = userThree;
        user.setUsuName("TESTE" + new Random().nextInt());
        Users expResult = userThree;
        Users result = instance.setUser(user);
        Users resultFromGet = instance.getUser(user.getUsuId());
        assertEquals(expResult, result);
        assertEquals(resultFromGet, result);
        assertEquals(resultFromGet.getUsuName(), result.getUsuName());
    }

    /**
     * Test of removeUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        Users user1 = new Users();
        user1.setUsuAdministrator(new Random().nextBoolean());
        user1.setUsuDentist(new Random().nextBoolean());
        user1.setUsuLogin("testLoginRemove" + new Random().nextInt());
        user1.setUsuName("testNameRemove" + new Random().nextInt());
        user1.setUsuPassword(user1.getUsuLogin());        
        user1 = instance.addUser(user1);
        instance.removeUser(user1);
        Users result = instance.getUser(user1.getUsuId());
        assertNull(result);
    }

    /**
     * Test of setPassword method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        String tmpPassword = new Random().nextInt() + "MyChange";
        instance.setPassword(userThree.getUsuId(), tmpPassword);
        Users result = instance.getUser(userThree.getUsuId());
        assertEquals(MD5Util.getMd5(tmpPassword), result.getUsuPassword());
    }

    /**
     * Test of addUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        Users user1 = new Users();
        user1.setUsuAdministrator(new Random().nextBoolean());
        user1.setUsuDentist(new Random().nextBoolean());
        user1.setUsuLogin("testLoginAdd" + new Random().nextInt());
        user1.setUsuName("testNameAdd" + new Random().nextInt());
        user1.setUsuPassword(user1.getUsuLogin());        
        user1 = instance.addUser(user1);
        Users result = instance.getUser(user1.getUsuId());
        instance.removeUser(result);
        assertEquals(user1, result);
    }

    /**
     * Test of getUserByLoginAndPassword method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetUserByLoginAndPassword() throws Exception {
        System.out.println("getUserByLoginAndPassword");
        String login = userOne.getUsuLogin();
        String password = userOne.getUsuLogin();
        Users expResult = userOne;
        Users result = instance.getUserByLoginAndPassword(login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class UserService.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        List<Users> expResult = new LinkedList<>();
        expResult.add(userOne);
        expResult.add(userTwo);
        expResult.add(userThree);
        List<Users> result = instance.getUsers();
        assertEquals(expResult.size(), result.size());
    }    
}
