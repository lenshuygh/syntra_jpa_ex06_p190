package beers.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
