package beers.service;

import beers.model.Beer;
import beers.model.Brewer;

import java.util.List;

public interface BeerService {
    Beer saveBeer(Beer beer);

    Beer getBeerById(int beerId);

    List<Beer> getBeerByBrewerId(Brewer brewer);
}
