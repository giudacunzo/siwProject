import model.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;

/**
 * Created by giuseppe on 14/05/15.
 */
@ManagedBean
public class ProductController {
    private String name;
    private String code;
    private String description;
    private Float price;
    private Integer quantity;
    private List<Provider> providers;
    private Product product;


    @EJB(beanName = "cFacade")
    private ProductFacade facade;

    public ProductController() {

    }

    public String createProduct(){
        facade=new ProductFacade();
        product = facade.createProduct(code,name,price,description,quantity);
        if(product!=null) {
            return "error.html";
        }
        return "doneRegistration.html";
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public ProductFacade getFacade() {
        return facade;
    }

    public void setFacade(ProductFacade facade) {
        this.facade = facade;
    }
}
