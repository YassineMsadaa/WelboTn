package tn.esprit.spring.Entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class NewsfeedPost extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    @ManyToOne
    private BsUser users;

    public NewsfeedPost() {
    }

    public NewsfeedPost(Long id, String name, String content, BsUser users) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.users = users;

    }

    public NewsfeedPost(String name, String content, BsUser users) {
        this.name = name;
        this.content = content;
        this.users = users;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BsUser getUsers() {
        return users;
    }

    public void setUsers(BsUser users) {
        this.users = users;
    }





}
