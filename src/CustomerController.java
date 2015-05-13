import model.Address;
import model.Customer;
import model.CustomerFacade;
import model.PasswordHash;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.TransactionAttribute;
import javax.faces.bean.ManagedBean;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Created by giuseppe on 08/05/15..
 *
 */
@ManagedBean
public class CustomerController {

    @EJB(beanName = "cFacade")
    private CustomerFacade facade;

    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private Customer cust;

    public CustomerController() {
    }

    public String createCustomer(){
        try {
            this.password = PasswordHash.createHash(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
//        try {
            Customer customer = facade.createCustomer(name, lastName, birthDate, email, password);
        if (customer == null) {
            return "error.html";
        }
//        } catch (EJBTransactionRolledbackException e) {
//            return "error.html";
//        }
        return "jumbo.html";
    }

    public String getCustomer(String name) {
        this.cust = facade.getCustomer(name);
        return "customer.jsp";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerFacade getFacade() {
        return facade;
    }

    public void setFacade(CustomerFacade facade) {
        this.facade = facade;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
}
