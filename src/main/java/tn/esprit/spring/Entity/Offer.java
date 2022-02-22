package tn.esprit.spring.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private Boolean state;
    private LocalDateTime createdAt;
    private LocalDateTime startsAt;
    private LocalDateTime expiresAt;
    @ManyToOne
    private Collaborator collaborator;

}
