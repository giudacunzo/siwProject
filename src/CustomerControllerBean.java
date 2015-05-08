import model.Address;
import model.Customer;
import model.User;
import model.CustomerFacade;

import javax.annotation.ManagedBean;
import java.util.Date;

/**
 * Created by giuseppe on 08/05/15.
 */
@ManagedBean
public class CustomerControllerBean {
    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private String password;
    private Customer customer;

    public CustomerControllerBean() {
    }

    public String createCustomer(){
        CustomerFacade customerFacade =new CustomerFacade();
        this.customer= customerFacade.createCustomer(name, lastName, birthDate, email, new Address());
        if(this.customer!=null)
            return "doneRegistration.html";
        return "error.html";
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
}
