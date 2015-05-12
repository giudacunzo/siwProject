package model;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

/**
 * Created by giuseppe on 08/05/15..
 *
 */

@Stateless(name = "cFacade")
public class CustomerFacade {

    @PersistenceContext(unitName = "siwprj")
    private EntityManager em;

    public Customer createCustomer(String name, String lastname, Date birthDate, String email, Address address){
        Customer customer = new Customer(name, lastname, birthDate, email, null); /*di prova*/
        customer.setRegistrationDate(birthDate); /*di prova*/
        this.em.persist(customer);
        this.em.flush();
        return customer;
    }

    public Customer getCustomer(String name) {
        Query query;
        query = this.em.createQuery("select c from Customer c where :name = c.name");
        query.setParameter("name",name);
        return (Customer) query.getResultList().get(0);
    }

    public EntityManager getEm() {
        return this.em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
