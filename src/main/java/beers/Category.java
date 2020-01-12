package beers;

import java.util.Set;

public class Category {
    private int id;
    private String category;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", beers=" + beers +
                '}';
    }
}
