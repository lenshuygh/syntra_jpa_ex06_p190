package beers.service;

import beers.model.Brewer;

import javax.persistence.*;
import java.util.List;

public class BrewerServiceImpl implements BrewerService {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    List<Brewer> brewerList = null;
    EntityTransaction tx = null;

    public void startSession() {
        emf = Persistence.createEntityManagerFactory("beers");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @Override
    public List<Brewer> getAllBrewers() {
        startSession();
        TypedQuery<Brewer> query = em.createQuery("SELECT b FROM Brewers b", Brewer.class);
        brewerList = getBrewerByQuery(query);
        return brewerList;
    }

    @Override
    public Brewer getBrewerById(int brewerId) {
        startSession();
        try {
            return em.find(Brewer.class, brewerId);
        }finally {
            closeSession();
        }
    }

    private List<Brewer> getBrewerByQuery(TypedQuery<Brewer> categoryTypedQuery) {
        try {
            return categoryTypedQuery.getResultList();
        } finally {
            closeSession();
        }
    }

    private void closeSession() {
        tx.commit();
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
