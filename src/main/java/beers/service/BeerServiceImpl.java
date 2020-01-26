package beers.service;

import beers.model.Beer;
import beers.model.Brewer;

import javax.persistence.*;
import java.util.List;

public class BeerServiceImpl implements BeerService {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;
    List<Beer> beerList = null;

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

    @Override
    public Beer getBeerById(int beerId) {
        try {
            startSession();
            return em.find(Beer.class, beerId);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Beer> getBeersByName(String beerName) {
        try {
            startSession();
            TypedQuery<Beer> query = em.createQuery("SELECT b FROM Beers b WHERE upper(b.Name) like upper(?1) ", Beer.class);
            query.setParameter(1, "%" + beerName + "%");
            beerList =  query.getResultList();
            return beerList;
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Beer> getBeerByBrewerId(Brewer brewer) {
        try {
            startSession();
            TypedQuery<Beer> query = em.createQuery("SELECT b FROM Beers b WHERE b.brewer = ?1",Beer.class);
            query.setParameter(1,brewer);
            return query.getResultList();
        }finally {
            closeSession();
        }
    }

    public void closeSession() {
        tx.commit();
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
