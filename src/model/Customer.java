package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends User{

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Order> orders;

    public Customer(String name, String lastname, Date birthDate, String email, Address address) {
        super(name, lastname, birthDate, email, address);
    }

    public Customer(String name, String lastname, Date birthDate, Date registrationDate, String email, String password) {
        super(name, lastname, birthDate, registrationDate, email, password);
    }

    public Customer() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}