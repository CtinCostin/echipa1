package ro.sda.echipa1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String continentName;

    @OneToMany(mappedBy = "continent",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>();




}
