package beers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
@Data
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
    @OneToMany(mappedBy = "brewer")
    private Set<Beer> beers;
}
