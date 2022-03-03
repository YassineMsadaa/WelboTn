package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
public class Badges implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 3, max = 32, message = "Name must be between 3 and 32 characters long") 
	private String nom;
	private String Data;
	private String NameFile;
	@Min(value = 150, message = "min value 150") 
	private String description;
	@JsonIgnore
	@ManyToOne
	private Votes vote;
	public Badges(
			@NotEmpty(message = "Name may not be empty") @Size(min = 3, max = 32, message = "Name must be between 3 and 32 characters long") String nom,
			String data, String nameFile, @Min(value = 150, message = "min value 150") String description) {
		super();
		this.nom = nom;
		Data = data;
		NameFile = nameFile;
		this.description = description;
	}
}
