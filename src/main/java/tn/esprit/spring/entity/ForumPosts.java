package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@SuppressWarnings("serial")

@Table( name = "ForumPosts")
public class ForumPosts implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; // Clé primaire
	
	private Long UserId;
	private String Description;
	private String Attachement;
	private Long CategorieId;
	
	@Temporal(TemporalType.DATE)
	private Date UploadTime;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Long getUserId() {return UserId;}
	public void setUserId(Long userId) {UserId = userId;}
	public String getDescription() {return Description;}
	public void setDescription(String description) {Description = description;}
	public String getAttachement() {return Attachement;}
	public void setAttachement(String attachement) {Attachement = attachement;}
	public Date getUploadTime() {return UploadTime;}
	public void setUploadTime(Date uploadTime) {UploadTime = uploadTime;}
	public Long getCategorieId() {return CategorieId;}
	public void setCategorieId(Long categorieId) {CategorieId = categorieId;}
}