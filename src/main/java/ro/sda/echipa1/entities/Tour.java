package ro.sda.echipa1.entities;


import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private City city;
    @ManyToOne
    private Airport airport;
    @ManyToOne
    private Hotel hotel;
    private LocalDate departureDate;
    private LocalDate dateOfReturn;
    private Integer numberOfDays;
    private TypeOfService typeOfService;
    private Double priceForAnAdult;
    private Double priceForAChild;
    private Boolean promoted;
    private Integer numberOfAdult;
    private Integer numberOfPLacesForChildren;


}
