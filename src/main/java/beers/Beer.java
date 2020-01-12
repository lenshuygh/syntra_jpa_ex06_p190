package beers;

import javax.persistence.Entity;
import java.sql.Blob;

@Entity
public class Beer {
    private int id;
    private String name;
    private float Price;
    private int Stock;
    private float alcohol;
    private int version;
    private Blob image;
    private Category category;
    private Brewer brewer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Price=" + Price +
                ", Stock=" + Stock +
                ", alcohol=" + alcohol +
                ", version=" + version +
                ", image=" + image +
                ", category=" + category +
                ", brewer=" + brewer +
                '}';
    }
}
