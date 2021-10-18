package ro.sda.echipa1.entities;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String airportName;

    @OneToOne
    private City city;
}
