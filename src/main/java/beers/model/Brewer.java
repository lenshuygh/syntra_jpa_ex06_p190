package beers.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
