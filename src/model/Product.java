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

    @Column(nullable = false)
    @ManyToMany(mappedBy = "providedProducts")
    private List<Provider> providers;



}
