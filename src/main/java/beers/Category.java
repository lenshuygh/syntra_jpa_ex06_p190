package beers;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
@Entity(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private Set<Beer> beers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Beer> getBeers() {
        return beers;
    }

    public void setBeers(Set<Beer> beers) {
        this.beers = beers;
    }

}
