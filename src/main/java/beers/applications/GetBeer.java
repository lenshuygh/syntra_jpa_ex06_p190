package beers.applications;

import beers.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GetBeer {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("beers");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Beer beer = em.find(Beer.class, getBeerId());
            System.out.println(beer);

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    private static int getBeerId() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the id of the beer you want info on: ");
        return scanner.nextInt();
    }
}
