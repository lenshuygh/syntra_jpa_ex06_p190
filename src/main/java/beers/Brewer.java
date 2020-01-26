package beers;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public Set<Beer> getBeers() {
        return beers;
    }

    public void setBeers(Set<Beer> beers) {
        this.beers = beers;
    }

}
