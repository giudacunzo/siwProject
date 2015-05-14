package Utility;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by gabbo on 14/05/15.
 *
 */
public class Helper {

    public static boolean isEmailUnique(EntityManager em, String email) {
        Query query = em.createQuery("select c.email from Customer c where c.email = :email");
        query.setParameter("email", email);
        return query.getResultList().isEmpty();
    }
}
