package beers.service;

import beers.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BeerServiceImpl implements BeerService {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;

    public void startSession() {
        emf = Persistence.createEntityManagerFactory("beers");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Override
    public Beer saveBeer(Beer beer) {
        startSession();
        try {
            em.persist(beer);
            return beer;
        } finally {
            closeSession();
        }
    }

    public void closeSession() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
