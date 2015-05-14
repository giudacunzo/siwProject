package model;

import Utility.Helper;

import javax.ejb.*;
import javax.persistence.*;
import javax.persistence.metamodel.Type;
import java.util.Date;

/**
 * Created by giuseppe on 08/05/15
 *
 */

@Stateless(name = "cFacade")
public class CustomerFacade {

    public static final String MESSAGE_OK = "Everything ok, customer created with succes!";
    public static final String MESSAGE_ERROR_EMAIL_ALREADY_USED = "Email already in use!";
    public static final String MESSAGE_ERROR_GENERIC = "Ooops something went wrong";
    public static final String MESSAGE_ERROR_CUSTOMER_NOT_FOUND = "Customer not found";

    @PersistenceContext(unitName = "siwprj")
    private EntityManager em;




    public String createCustomer(String name, String lastname, Date birthDate, String email, String pass){
        String message;
        if(Helper.isEmailUnique(em,email)) {
            Customer customer = new Customer(name, lastname, birthDate, new Date(), email, pass);
            this.em.persist(customer);
            message = MESSAGE_OK;
        }
        else {
            message = MESSAGE_ERROR_EMAIL_ALREADY_USED;
        }
        return message;
    }

    public String updateCustomer(String name, String lastname, Date birthdate, String newEmail, String oldEmail) {
        String message;
        Customer customer;
        TypedQuery<Customer> query = buildSelectCustomerByEmail(oldEmail);
        try {
            customer = query.getSingleResult();
            message = MESSAGE_OK;
        } catch (NoResultException e) {
            return MESSAGE_ERROR_CUSTOMER_NOT_FOUND;
        }
        customer.setName(name);
        customer.setLastname(lastname);
        customer.setBirthDate(birthdate);
        customer.setEmail(newEmail);
        return message;
    }

    public Customer retrieveCustomer(String email) {
        Customer customer;
        TypedQuery<Customer> query = buildSelectCustomerByEmail(email);
        try {
            customer = query.getSingleResult();
        } catch (NoResultException e) {
            customer = null;
        }
        return customer;
    }

    public String deleteCustomer(String email) {
        Customer customer;
        Query query = buildSelectCustomerByEmail(email);
        try {
            customer = (Customer) query.getSingleResult();
        } catch (NoResultException e) {
            return MESSAGE_ERROR_GENERIC;
        }
        em.remove(customer);
        return MESSAGE_OK; /*da provare assolutamente*/
    }


    private TypedQuery<Customer> buildSelectCustomerByEmail(String email) {
        TypedQuery<Customer> query;
        query = this.em.createQuery("select c from Customer c where :email = c.email", Customer.class);
        query.setParameter("email",email);
        return query;
    }

    public EntityManager getEm() {
        return this.em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
