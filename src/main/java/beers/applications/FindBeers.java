package beers.applications;

import beers.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindBeers {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("beers");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Beer> query = entityManager.createNamedQuery("beersByAlcoholBetween",Beer.class);
        query.setParameter(1,5F);
        query.setParameter(2,8F);
        query.getResultList().stream().forEach(System.out::println);
    }
}
