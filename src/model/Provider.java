package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gabbo on 06/05/15.
 */
@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Product> providedProducts;

    @Column(nullable = false)
    private String vatNumber;

    private String phoneNumber;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    private String email;

    public Provider(List<Product> providedProducts, String vatNumber, String phoneNumber, Address address, String email) {
        this.providedProducts = providedProducts;
        this.vatNumber = vatNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public Provider() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProvidedProducts() {
        return providedProducts;
    }

    public void setProvidedProducts(List<Product> providedProducts) {
        this.providedProducts = providedProducts;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
