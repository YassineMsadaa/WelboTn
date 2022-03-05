package tn.esprit.spring.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Size(max = 50)
    private String name;

    private String description;

    @OneToMany(mappedBy = "departement")
    private List<User> users;

}
