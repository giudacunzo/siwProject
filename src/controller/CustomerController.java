package controller;

import model.Customer;
import model.CustomerFacade;
import Utility.PasswordHash;

import javax.ejb.EJB;
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
    private String emailForResearch;
    private String password;
    private Customer cust;
    private String message2User;
    private String error2User;

    public CustomerController() {
    }

    /**
     * metodo finito e provato, aggiunto controllo sulla mail
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public String createCustomer() throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.password = PasswordHash.createHash(password);
        String message = facade.createCustomer(name, lastName, birthDate, email, password);
        if (message.equals(CustomerFacade.MESSAGE_OK)) {
            message2User = message;
            clearFormField();
        }
        else
            error2User = message;
        return "register.xhtml";
    }

    /**
     * metodo da finire anche nella facade
     * @return
     */
    public String retrieveCustomer() {
        this.cust = facade.retrieveCustomer(emailForResearch);
        /*da finire*/
        return "customer.jsp";
    }

    /**
     * metodo da finire anche nella facade, parzialmente provato
     * @return
     */
    public String updateCustomer() {
        String message = facade.updateCustomer(name,lastName,birthDate,email,emailForResearch);
        return "";
    }

    /**
     * metodo da finire anche nella facade
     * @return
     */
    public String deleteCustomer() {
        String message = facade.deleteCustomer(emailForResearch);
        if(message.equals(CustomerFacade.MESSAGE_OK))
            message2User = message;
        else
            error2User = message;
        return "";
    }

    private void clearFormField() {
        this.name = null;
        this.lastName = null;
        this.email = null;
        this.birthDate = null;
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

    public String getMessage2User() {
        return message2User;
    }

    public void setMessage2User(String message2User) {
        this.message2User = message2User;
    }

    public String getError2User() {
        return error2User;
    }

    public void setError2User(String error2User) {
        this.error2User = error2User;
    }

    public String getEmailForResearch() {
        return emailForResearch;
    }

    public void setEmailForResearch(String emailForResearch) {
        this.emailForResearch = emailForResearch;
    }
}
