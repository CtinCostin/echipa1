package ro.sda.echipa1.entities;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hotelName;

    @Enumerated(EnumType.STRING)
    private StarRating starRating;

    private String description;

    @ManyToOne
    private City city;
}
