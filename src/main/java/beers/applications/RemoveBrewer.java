package beers.applications;

import beers.service.BrewerService;
import beers.service.BrewerServiceImpl;

import java.util.Scanner;

public class RemoveBrewer {
    static BrewerService brewerService = new BrewerServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        brewerService.getAllBrewers().stream().forEach(System.out::println);
        System.out.printf("Please enter the id of the brewer you want to delete (warn: beers of this brewer will also get deleted : ");
        brewerService.removeBrewer(scanner.nextInt());
    }
}
