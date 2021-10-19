package ro.sda.echipa1.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Card card;

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
}
