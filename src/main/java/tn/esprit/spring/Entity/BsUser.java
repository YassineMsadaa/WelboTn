package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class BsUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="postedby", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<NewsfeedPost> newsfeedPosts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="commentedby", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

}
