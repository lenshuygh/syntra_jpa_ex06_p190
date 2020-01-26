package beers.service;

import beers.model.Brewer;

import javax.persistence.*;
import java.util.List;

public class BrewerServiceImpl implements BrewerService {
    @Override
    public List<Brewer> getAllBrewers() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Brewer> brewerList= null;
        try {
            emf = Persistence.createEntityManagerFactory("beers");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            TypedQuery<Brewer> query = em.createQuery("SELECT b FROM Brewers b", Brewer.class);
            brewerList = query.getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return brewerList;
    }
}
