package ro.sda.echipa1.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private Long cardNumber;
    private Date expiredDate;
    private Integer securityCode;
}
