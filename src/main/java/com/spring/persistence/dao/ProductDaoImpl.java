package com.spring.persistence.dao;

import com.spring.persistence.domain.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andrey on 29.12.2014.
 */
@Component
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    private EntityManager em;

    /* (non-Javadoc)
	 * @see guest.GuestDAO#persist(guest.Guest)
	 */

    @Override
    public void persist(Product pr) {
        em.persist(pr);
    }


    /* (non-Javadoc)
	 * @see guest.GuestDAO#getAllGuests()
	 */

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p ORDER BY p.id", Product.class);
        List<Product> list = query.getResultList();

        return list ;
    }
}
