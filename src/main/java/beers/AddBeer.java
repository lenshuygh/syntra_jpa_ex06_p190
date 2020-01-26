package beers;

import beers.service.BrewerService;
import beers.service.BrewerServiceImpl;
import beers.service.CategoryService;
import beers.service.CategoryServiceImpl;

public class AddBeer {
    public static void main(String[] args) {
        BrewerService brewerService = new BrewerServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();

        brewerService.getAllBrewers().stream().map(Brewer::toString).forEach(System.out::println);
        categoryService.getAllCategories().stream().map(Category::toString).forEach(System.out::println);
        System.out.println(categoryService.getCategoriesByName("geuz").toString());
        System.out.println(categoryService.getCategoriesByName("Traditionele Geuze").toString());
    }
}
