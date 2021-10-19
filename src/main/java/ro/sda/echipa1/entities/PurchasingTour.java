package ro.sda.echipa1.entities;

import javax.persistence.*;

@Entity
@Table(name = "purchasing_tour")
public class PurchasingTour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Tour tour;

    @OneToOne
    private User user;

}
