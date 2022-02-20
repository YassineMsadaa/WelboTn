package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BsUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<NewsfeedPost> baskets = new ArrayList<>();

    public BsUser() {
    }

    public BsUser(Long id, String name, List<NewsfeedPost> baskets) {
        this.id = id;
        this.name = name;
        this.baskets = baskets;
    }

    public BsUser(String name, List<NewsfeedPost> baskets) {
        this.name = name;
        this.baskets = baskets;
    }
}
