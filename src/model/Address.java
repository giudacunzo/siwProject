package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by gabbo on 06/05/15.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
