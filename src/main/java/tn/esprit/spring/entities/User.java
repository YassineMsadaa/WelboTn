package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String role;
	private String name;
	private String lastname;
	private String email;
	private int departementId;
	private Date birthDate;
	private int phoneNum;
	private String jobTitle;
	private String profilePic;
	@JsonIgnore
	@OneToMany(cascade= CascadeType.ALL, mappedBy="user")
	private List<Votes> vote;
	@JsonIgnore
	@ManyToMany(mappedBy="evalUser", cascade= CascadeType.ALL)
	private List<Evaluation> evaluation;
	

}
