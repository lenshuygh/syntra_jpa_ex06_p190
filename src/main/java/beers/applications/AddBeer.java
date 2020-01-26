package beers.applications;

import beers.model.Brewer;
import beers.model.Category;
import beers.service.BrewerService;
import beers.service.BrewerServiceImpl;
import beers.service.CategoryService;
import beers.service.CategoryServiceImpl;

import java.util.Scanner;

public class AddBeer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrewerService brewerService = new BrewerServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        brewerService.getAllBrewers().stream().map(Brewer::toString).forEach(System.out::println);
        categoryService.getAllCategories().stream().map(Category::toString).forEach(System.out::println);
        System.out.println(categoryService.getCategoriesByName("geuz").toString());
        System.out.println(categoryService.getCategoriesByName("Traditionele Geuze").toString());

        System.out.printf("Enter an id for a Brewer: ");
        int brewerId = scanner.nextInt();
        System.out.printf("\nEnter an id for a category: ");
        int categoryId= scanner.nextInt();


    }
}
