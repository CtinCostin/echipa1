package ro.sda.echipa1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Continent continent;

    @OneToMany(mappedBy = "country",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<City> cityList = new ArrayList<>();

    public Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }
}
