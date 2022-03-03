package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.enume.ClassType;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date evaldate;
	private String Email;
	@Enumerated (EnumType.STRING)
	private ClassType classes;
	@JsonIgnore
	@ManyToMany(cascade= CascadeType.ALL)
	private List<User> evalUser;
	}