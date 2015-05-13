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

    public Customer createCustomer(String name, String lastname, Date birthDate, String email, String pass){
        Customer customer = null;
        Query query = em.createQuery("select c.email from Customer c where c.email = :email");
        query.setParameter("email", email);
        boolean newEmailInserted = query.getResultList().isEmpty();
        if(newEmailInserted) {
            customer = new Customer(name, lastname, birthDate, new Date(), email, pass);
            this.em.persist(customer);
        }
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
