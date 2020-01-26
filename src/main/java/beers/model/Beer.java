package beers.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Beers")
@Builder
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float Price;
    private int Stock;
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


