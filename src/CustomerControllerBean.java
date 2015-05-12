import model.Address;
import model.Customer;
import model.CustomerFacade;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.faces.bean.ManagedBean;
import java.util.Date;

/**
 * Created by giuseppe on 08/05/15..
 *
 */
@ManagedBean
public class CustomerControllerBean {

    @EJB(beanName = "cFacade")
    private CustomerFacade facade;

    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private Customer cust;

    public CustomerControllerBean() {
    }

    @TransactionAttribute
    public String createCustomer(){
        Address address = new Address("vasca","navale","roma",350L,"boh");
        Customer customer = facade.createCustomer(name, lastName, new Date(), email, address);
        return "index.html";
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
