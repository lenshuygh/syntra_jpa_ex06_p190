package beers.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NamedQuery(name = "uniqueBrewersWithBeersByAlcohol", query = "select distinct br from Brewers br join br.beers b where b.alcohol = ?1")
@NamedQuery(name = "uniqueBrewersWithBeersByCategory", query = "select distinct br from Brewers br join br.beers b join Categories c on b.category = c where lower(c.category) = lower(?1)")
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Brewers")
public class Brewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private int turnover;
    @ToString.Exclude
    @OneToMany(mappedBy = "brewer",orphanRemoval = true)
    private Set<Beer> beers;
}
