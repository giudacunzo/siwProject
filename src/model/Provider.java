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

    @Column(nullable = false)
    private List<Product> providedProducts;

    @Column(nullable = false)
    private String pIva;

    private String phoneNumber;

    @Column(nullable = false)
    private Address address;
    private String email;
}
