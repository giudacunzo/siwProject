package model;

import java.util.Date;

/**
 * Created by giuseppe on 08/05/15.
 */
public class CustomerFacade {
   public Customer createCustomer(String name, String lastname, Date birthDate, String email, Address address){
       Customer customer = new Customer(name, lastname, birthDate, email, address);
       return customer;
    }
}
