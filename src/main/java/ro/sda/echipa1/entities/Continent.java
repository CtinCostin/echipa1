package ro.sda.echipa1.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1, max=100,message = "Please use minimum 1 character and maximum 100 for name")
    private String name;

    @OneToMany(mappedBy = "continent",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>();

    public Continent() {
    }

    public Continent(String name, List<Country> countryList) {
        this.name = name;
        this.countryList = countryList;

    }



}
