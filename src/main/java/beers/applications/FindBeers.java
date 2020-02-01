package beers.applications;

import beers.model.Beer;
import beers.model.Brewer;
import beers.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindBeers {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("beers");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Beers with alc. % between 5.0 and 8.0");
        TypedQuery<Beer> query = entityManager.createNamedQuery("beersByAlcoholBetween", Beer.class);
        query.setParameter(1, 5F);
        query.setParameter(2, 8F);
        query.getResultList().stream().forEach(System.out::println);

        System.out.println("Beers with alc. % of 4, 6, 8 or 10");
        query = entityManager.createNamedQuery("beersByAlcoholInArrayOf4Ints", Beer.class);
        query.setParameter(1, 4F);
        query.setParameter(2, 6F);
        query.setParameter(3, 8F);
        query.setParameter(4, 10F);
        query.getResultList().stream().forEach(System.out::println);

        System.out.println("Beers with 'kriek' in the name");
        query = entityManager.createNamedQuery("beersByPartOfName", Beer.class);
        query.setParameter(1, "%" + "kriek" + "%");
        query.getResultList().stream().forEach(System.out::println);

        System.out.println("Beers with a brewery in Ghent (zipcode 9000)");
        query = entityManager.createNamedQuery("beersByBrewerZipCode", Beer.class);
        query.setParameter(1, "9000");
        query.getResultList().stream().forEach(System.out::println);

        System.out.println("Beers with category 'Tripel'");
        query = entityManager.createNamedQuery("beersByCategory", Beer.class);
        query.setParameter(1, "Tripel");
        query.getResultList().stream().forEach(System.out::println);

        System.out.println("Unique Categories of Beers with with alcohol % of 9");
        TypedQuery<Category> query2 = entityManager.createNamedQuery("uniqueCategoriesWithBeersByAlcohol", Category.class);
        query2.setParameter(1, 9F);
        query2.getResultList().stream().forEach(System.out::println);

        System.out.println("Unique Brewers of Beers with with alcohol % of 10");
        TypedQuery<Brewer> query3 = entityManager.createNamedQuery("uniqueBrewersWithBeersByAlcohol", Brewer.class);
        query3.setParameter(1, 10F);
        query3.getResultList().stream().forEach(System.out::println);

        System.out.println("Unique Brewers of Beers with with 'Pils' in it's category");
        TypedQuery<Brewer> query4 = entityManager.createNamedQuery("uniqueBrewersWithBeersByCategory", Brewer.class);
        query4.setParameter(1, "Pils");
        query4.getResultList().stream().forEach(System.out::println);

        System.out.println("Average price of all beers of category 'pils'");
        query = entityManager.createNamedQuery("beersByCategory", Beer.class);
        query.setParameter(1, "Pils");
        System.out.printf("%.2f",query.getResultList().stream().mapToDouble(Beer::getPrice).average().getAsDouble());
    }
}
