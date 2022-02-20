package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 256)
    private String text;

    @NotBlank
    private Date date;

    @NotBlank
    private boolean viewed;

    @NotBlank
    private Integer recipientId;
///////////////////
    @ManyToOne
    private User user;


}
