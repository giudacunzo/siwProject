package model;

import javax.persistence.*;

/**
 * Created by gabbo on 06/05/15.
 */
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long unitprice;

    private Long quantity;

    @ManyToOne
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderLine(Long unitprice, Long quantity, Order order, Product product) {
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public OrderLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Long unitprice) {
        this.unitprice = unitprice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
