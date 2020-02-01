package beers.model;

import lombok.*;

import javax.persistence.*;

@NamedQuery(name = "beersByAlcoholBetween", query = "select b from Beers b where b.alcohol between ?1 and ?2")
@NamedQuery(name = "beersByAlcoholInArrayOf4Floats", query = "select b from Beers b where b.alcohol in (?1,?2,?3,?4)")
@NamedQuery(name = "beersByPartOfName", query = "select b from Beers b where lower(b.name) like lower(?1)")
@NamedQuery(name = "beersByBrewerZipCode", query = "select b from Beers b join b.brewer br where br.zipCode = ?1")
@NamedQuery(name = "beersByCategory", query = "select b from Beers b join b.category c where c.category = ?1")
@NamedQuery(name = "avgPriceOfBeersByCategory", query = "select avg (b.price) from Beers b join b.category c where c.category = ?1")
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


