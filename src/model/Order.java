package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by gabbo on 06/05/15.
 */
@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date opened;

    private Date closed;

    private Date evaded;

    @Column(nullable = false)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderLine> orderLines;

    public Order(Date opened, Date closed, Date evaded, Customer customer) {
        this.opened = opened;
        this.closed = closed;
        this.evaded = evaded;
        this.customer = customer;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public Date getEvaded() {
        return evaded;
    }

    public void setEvaded(Date evaded) {
        this.evaded = evaded;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
