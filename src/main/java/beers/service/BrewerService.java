package beers.service;

import beers.model.Brewer;

import java.util.List;

public interface BrewerService {
    List<Brewer> getAllBrewers();

    Brewer getBrewerById(int brewerId);
}
