package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siwprjtest");
		EntityManager em = emf.createEntityManager();

		Product product = new Product();
		product.setName("KRIDDIG");
		product.setPrice(3.5F);
		product.setDescription("A wonderful bla bla");
		product.setCode("9781853262715-AA");
        product.setRemainingQuantity(345);

        Product product2 = new Product();
        product2.setName("BLAH");
        product2.setPrice(4.9F);
        product2.setDescription("A wonderful boh boh boh");
        product2.setCode("374569568546-BB");
        product2.setRemainingQuantity(200);


        List<Product> providedProducts = new ArrayList<>();
        providedProducts.add(product);
        providedProducts.add(product2);


		Address address = new Address("vasca navale", "Roma", "Italia", 875L, "boh");
		User u1 = new Customer("fabio","sola",new Date(),"ciao@ciao.it", address);
        u1.setRegistrationDate(new Date());
		User u3 = new Customer("giulio","verdi",new Date(),"ciao@boh.it", address);
        u3.setRegistrationDate(new Date());
		User u2 = new Administrator("giuseppe","garibaldi",new Date(),"a@it.it", new Address("pincherle","Roma","Italia",456L,"nonso"));
        u2.setRegistrationDate(new Date());
        User u4 = new Customer("giulio","verdi",new Date(),"ciao@boh.it", address);
        u4.setRegistrationDate(new Date());

        Provider provider = new Provider(providedProducts,"545346","656868",address,"ciao@hi.it");
        List<Provider> providers = new ArrayList<>();
        providers.add(provider);

        product.setProviders(providers);
        product2.setProviders(providers);
        provider.setProvidedProducts(providedProducts);

		Order o1 = new Order(new Date(), new Date(), new Date(),(Customer)u1);
		Order o2 = new Order(new Date(), new Date(), new Date(),(Customer)u1);
		Order o3 = new Order(new Date(), new Date(), new Date(),(Customer)u3);

        List<Order> u1Orders = new ArrayList<>();
        u1Orders.add(o1);
        u1Orders.add(o2);

        List<Order> u3Orders = new ArrayList<>();
        u3Orders.add(o3);

        ((Customer) u1).setOrders(u1Orders);
        ((Customer) u3).setOrders(u3Orders);

        OrderLine orderLine1 = new OrderLine(10L,20L,o1,product);
        OrderLine orderLine2 = new OrderLine(20L,34L,o1,product2);

        List<OrderLine> orderlineList = new ArrayList<>();
        orderlineList.add(orderLine1);
        orderlineList.add(orderLine2);

        o1.setOrderLines(orderlineList);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product2);
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
        em.persist(u4);
		tx.commit();

		em.close();
		emf.close();
	}
}