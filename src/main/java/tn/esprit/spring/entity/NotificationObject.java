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

@Table( name = "Notifications")
public class NotificationObject implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id; // Clé primaire
	
	private int ForumPostId;
	private int NewsFeedPostId;
	private int type; //comment=1; like=2; flagged by admin = 3;
	
	@Temporal(TemporalType.DATE)
	private Date CreationDate;

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getForumPostId() {return ForumPostId;}
	public void setForumPostId(int forumPostId) {ForumPostId = forumPostId;}
	public int getNewsFeedPostId() {return NewsFeedPostId;}
	public void setNewsFeedPostId(int newsFeedPostId) {NewsFeedPostId = newsFeedPostId;}
	public int getType() {return type;}
	public void setType(int type) {this.type = type;}
	public Date getCreationDate() {return CreationDate;}
	public void setCreationDate(Date creationDate) {CreationDate = creationDate;}
}