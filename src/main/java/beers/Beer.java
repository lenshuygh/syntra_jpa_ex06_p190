package beers;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name = "Beers")
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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
}
