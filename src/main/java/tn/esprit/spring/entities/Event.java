package com.jawher.pide.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEvent ;
	@Column(nullable=false)
	private String name ;
	@Column(nullable=false)
	private Date startTime ;
	@Column(nullable=false)
	private Date endTime ;
	@Column(nullable=false)
	private String image ;
	@ManyToMany(mappedBy = "events", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List <User> users ;
	


	

}
