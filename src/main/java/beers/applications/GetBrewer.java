package beers.applications;

import beers.model.Beer;
import beers.model.Brewer;
import beers.service.BeerService;
import beers.service.BeerServiceImpl;
import beers.service.BrewerService;
import beers.service.BrewerServiceImpl;

import java.util.List;
import java.util.Scanner;

public class GetBrewer {
    static BrewerService brewerService = new BrewerServiceImpl();
    static BeerService beerService = new BeerServiceImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the ID of the brewer you want all info on: ");
        Brewer brewer = brewerService.getBrewerById(scanner.nextInt());
        List<Beer> beerList = beerService.getBeerByBrewerId(brewer);
        System.out.println(brewer);
        beerList.stream().forEach(System.out::println);
    }
}
