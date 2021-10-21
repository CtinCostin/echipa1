package ro.sda.echipa1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Hotel> hotelList = new ArrayList<>();

    @OneToOne(mappedBy = "city")
    private Airport airport;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
