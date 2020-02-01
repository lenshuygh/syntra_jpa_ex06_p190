package beers.applications;

import beers.model.Beer;
import beers.model.Brewer;
import beers.model.Category;

import javax.persistence.*;

public class FindBeers {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("beers");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Beers with alc. % between 5.0 and 8.0");
        TypedQuery<Beer> query = entityManager.createNamedQuery("beersByAlcoholBetween", Beer.class);
        query.setParameter(1, 5F);
        query.setParameter(2, 8F);
        doQuery(query);

        System.out.println("Beers with alc. % of 4, 6, 8 or 10");
        query = entityManager.createNamedQuery("beersByAlcoholInArrayOf4Floats", Beer.class);
        query.setParameter(1, 4F);
        query.setParameter(2, 6F);
        query.setParameter(3, 8F);
        query.setParameter(4, 10F);
        doQuery(query);

        System.out.println("Beers with 'kriek' in the name");
        query = entityManager.createNamedQuery("beersByPartOfName", Beer.class);
        query.setParameter(1, "%" + "kriek" + "%");
        doQuery(query);

        System.out.println("Beers with a brewery in Ghent (zipcode 9000)");
        query = entityManager.createNamedQuery("beersByBrewerZipCode", Beer.class);
        query.setParameter(1, "9000");
        doQuery(query);

        System.out.println("Beers with category 'Tripel'");
        query = entityManager.createNamedQuery("beersByCategory", Beer.class);
        query.setParameter(1, "Tripel");
        doQuery(query);

        System.out.println("Unique Categories of Beers with with alcohol % of 9");
        TypedQuery<Category> query2 = entityManager.createNamedQuery("uniqueCategoriesWithBeersByAlcohol", Category.class);
        query2.setParameter(1, 9F);
        doQuery(query2);

        System.out.println("Unique Brewers of Beers with with alcohol % of 10");
        TypedQuery<Brewer> query3 = entityManager.createNamedQuery("uniqueBrewersWithBeersByAlcohol", Brewer.class);
        query3.setParameter(1, 10F);
        doQuery(query3);

        System.out.println("Unique Brewers of Beers with with 'Pils' in it's category");
        query3 = entityManager.createNamedQuery("uniqueBrewersWithBeersByCategory", Brewer.class);
        query3.setParameter(1, "Pils");
        doQuery(query3);

        System.out.println("Average price of all beers of category 'pils'");
        query = entityManager.createNamedQuery("beersByCategory", Beer.class);
        query.setParameter(1, "Pils");
        System.out.printf("%.2f",query.getResultList().stream().mapToDouble(Beer::getPrice).average().getAsDouble());

        if( entityManagerFactory != null){
            entityManagerFactory.close();
        }
        if(entityManager != null){
            entityManager.close();
        }
    }

    private static void doQuery(TypedQuery query){
        System.out.println("elements: " + query.getResultList().size());
        System.out.println("------------");
        query.getResultList().stream().forEach(System.out::println);
        System.out.println("************");
        System.out.println();
    }
}
