package beers.model;

import lombok.*;

import javax.persistence.*;

@NamedQuery(name="beersByAlcoholBetween",query = "select b from Beers b where b.alcohol between ?1 and ?2")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private int stock;
    private float alcohol;
    private int version;
    @Lob
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "BrewerId")
    private Brewer brewer;
}


