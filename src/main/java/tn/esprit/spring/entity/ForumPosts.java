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
	private int id; // Clé primaire
	
	private int UserId;
	private String Description;
	private String Attachement;
	private int CategorieId;
	
	@Temporal(TemporalType.DATE)
	private Date UploadTime;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getUserId() {return UserId;}
	public void setUserId(int userId) {UserId = userId;}
	public String getDescription() {return Description;}
	public void setDescription(String description) {Description = description;}
	public String getAttachement() {return Attachement;}
	public void setAttachement(String attachement) {Attachement = attachement;}
	public Date getUploadTime() {return UploadTime;}
	public void setUploadTime(Date uploadTime) {UploadTime = uploadTime;}
	public int getCategorieId() {return CategorieId;}
	public void setCategorieId(int categorieId) {CategorieId = categorieId;}
}