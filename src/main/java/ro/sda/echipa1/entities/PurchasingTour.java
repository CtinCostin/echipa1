package ro.sda.echipa1.entities;

import javax.persistence.*;

@Entity
@Table(name = "purchasing_tour")
public class PurchasingTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private TourOfferAdmin tourOfferAdmin;

    @OneToOne
    private User user;

    public PurchasingTour() {
    }
}
