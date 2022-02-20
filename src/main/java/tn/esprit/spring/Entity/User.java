package tn.esprit.spring.Entity;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(	name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nid"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "CellPhoneNumber")
        })

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 30)
    private String lastName;
    //National ID
    @NotBlank
    @Size(max = 10)
    private String nid;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private Date birthDate;

    @NotBlank
    @Size(max = 13)
    private String cellPhoneNumber;

    @Size(max = 13)
    private String homePhoneNumber;

    private String profilePicture;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    @ManyToOne
    private Departement departement;

}
