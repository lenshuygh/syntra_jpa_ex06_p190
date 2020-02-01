package beers.applications;

import beers.model.Beer;
import beers.model.Brewer;
import beers.model.Category;
import beers.service.*;

import java.util.Scanner;

public class AddBeer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrewerService brewerService = new BrewerServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();
        BeerService beerService = new BeerServiceImpl();

        brewerService.getAllBrewers().stream().map(Brewer::toString).forEach(System.out::println);
        categoryService.getAllCategories().stream().map(Category::toString).forEach(System.out::println);
        System.out.println(categoryService.getCategoriesByName("geuz").toString());
        System.out.println(categoryService.getCategoriesByName("Traditionele Geuze").toString());

        System.out.printf("Enter an id for a Brewer: ");
        int brewerId = scanner.nextInt();
        System.out.printf("\nEnter an id for a category: ");
        int categoryId= scanner.nextInt();

        Brewer brewer = brewerService.getBrewerById(brewerId);
        Category category = categoryService.getCategoryById(categoryId);

        System.out.println(category);
        System.out.println(brewer);

        Beer beer = Beer.builder().alcohol(5f).brewer(brewer).category(category).name("Lens Test Beer").price(6.66f).stock(70).version(1).build();
        System.out.println(beer);

        System.out.println(beerService.saveBeer(beer));
    }
}
