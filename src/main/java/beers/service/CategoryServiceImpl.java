package beers.service;

import beers.model.Category;

import javax.persistence.*;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    List<Category> categoryList = null;
    EntityTransaction tx = null;

    public void startSession() {
        emf = Persistence.createEntityManagerFactory("beers");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Override
    public List<Category> getAllCategories() {
        startSession();
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Categories c", Category.class);
        return getCategoriesByQuery(query);
    }

    @Override
    public List<Category> getCategoriesByName(String name) {
        startSession();
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Categories c where lower(c.category) like lower(?1)", Category.class);
        query.setParameter(1, "%" + name + "%");
        return getCategoriesByQuery(query);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        startSession();
        try {
            return em.find(Category.class, categoryId);
        } finally {
            closeSession();
        }
    }

    private List<Category> getCategoriesByQuery(TypedQuery<Category> categoryTypedQuery) {
        try {
            return categoryTypedQuery.getResultList();
        } finally {
            closeSession();
        }
    }

    private void closeSession() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}

