package com.spring.persistence.dao;

import com.spring.persistence.domain.Category;
import com.spring.persistence.domain.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Locale;

/**
 * Created by Andrey on 30.12.2014.
 */
@Component
public class CategoryDaoImpl implements  CategoryDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Category> getEnable() {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.enable=true ORDER BY c.position", Category.class);
        List<Category> list = query.getResultList();
        return list ;
    }

    @Override
    public List<Category> getAll() {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c  ORDER BY c.position", Category.class);
        List<Category> list = query.getResultList();
        return list ;
    }
}
