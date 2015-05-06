package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siwprj");
		EntityManager em = emf.createEntityManager();

		Product product = new Product();
		product.setName("KRIDDIG");
		product.setPrice(3.5F);
		product.setDescription("A wonderful bla bla");
		product.setCode("9781853262715-AA");
        product.setRemainingQuantity(345);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product);
		tx.commit();

		em.close();
		emf.close();
	}
}