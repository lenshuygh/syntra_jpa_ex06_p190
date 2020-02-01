package beers.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NamedQuery(name = "uniqueCategoriesWithBeersByAlcohol", query = "select distinct c from Categories c join c.beers b where b.alcohol = ?1")
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private Set<Beer> beers;
}
