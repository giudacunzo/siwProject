package model;

/**
 * Created by giuseppe on 14/05/15.
 */

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;


import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "cFacade")
public class ProductFacade {

    @PersistenceContext(unitName = "siwprj")
    private EntityManager entityManager;

    public Product createProduct(String code, String name, Float price, String description, Integer quantita) {
        List<Provider> providers=new ArrayList<>();
        Product product = new Product(name,code, description, price, quantita,providers);
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.persist(product);
        t.commit();
        entityManager.close();
        return product;
    }
    private void deleteProduct(Product product) {
        entityManager.remove(product);
    }
    public void deleteProduct(Long id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Product product = entityManager.find(Product.class, id);
        deleteProduct(product);
        tx.commit();
        entityManager.close();
    }

    public Product getProduct(String codice){
        Product p;
        EntityTransaction t= entityManager.getTransaction();
        t.begin();
        try {
            Query q=entityManager.createQuery("SELECT p FROM Product p WHERE p.code=:id");
            q.setParameter("id", codice);
            p=(Product) q.getSingleResult();
            t.commit();
        } catch (Exception e) {
            return null;
        }
        entityManager.close();
        return p;
    }
    public List<Product> getAllProducts(){
        List<Product> lista = new ArrayList<>();
        EntityTransaction t= entityManager.getTransaction();
        t.begin();
        Query q=entityManager.createQuery("SELECT p FROM Product p");
        lista=q.getResultList();
        t.commit();
        entityManager.close();
        return lista;
    }
}