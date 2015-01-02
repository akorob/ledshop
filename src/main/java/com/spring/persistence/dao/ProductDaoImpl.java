package com.spring.persistence.dao;

import com.spring.persistence.domain.FavoriteProduct;
import com.spring.persistence.domain.Product;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

/**
 * Created by Andrey on 29.12.2014.
 */
@Component
public class ProductDaoImpl implements  ProductDao {
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
                "SELECT p FROM Product p ORDER BY p.position", Product.class);
        List<Product> list = query.getResultList();

        return list ;
    }

    @Override
    public List<Product> getEnable() {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.enable=true ORDER BY p.position", Product.class);
        List<Product> list = query.getResultList();

        return list ;
    }

    @Override
    public List<Product> getFavorite() {
       /* TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.enable=true ORDER BY p.position", Product.class);
        List<Product> list = query.getResultList();*/

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root p = cq.from(FavoriteProduct.class);
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        return list ;
    }
}
