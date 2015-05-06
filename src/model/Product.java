package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gabbo on 06/05/15.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    private String description;

    private Float price;

    @Column(nullable = false)
    private Integer remainingQuantity;

    @ManyToMany(mappedBy = "providedProducts")
    private List<Provider> providers;

    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderlineList;


    public Product(String name, String code, String description, Float price, Integer remainingQuantity, List<Provider> providers) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.remainingQuantity = remainingQuantity;
        this.providers = providers;
    }

    public Product() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public List<OrderLine> getOrderlineList() {
        return orderlineList;
    }

    public void setOrderlineList(List<OrderLine> orderlineList) {
        this.orderlineList = orderlineList;
    }
}
