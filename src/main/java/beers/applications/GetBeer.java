package beers.applications;

import beers.model.Beer;
import beers.service.BeerService;
import beers.service.BeerServiceImpl;

import java.util.Scanner;

public class GetBeer {
    static BeerService beerService = new BeerServiceImpl();

    public static void main(String[] args) {
            Beer beer = beerService.getBeerById(getBeerId());
            System.out.println(beer);
    }

    private static int getBeerId() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the id of the beer you want info on: ");
        return scanner.nextInt();
    }
}
