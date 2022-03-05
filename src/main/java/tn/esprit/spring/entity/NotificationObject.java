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

@Table( name = "NotificationObject")
public class NotificationObject implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; // Clé primaire
	
	private Long ForumPostId;
	private Long NewsFeedPostId;
	private int type; //comment=1; like=2; flagged by admin = 3;
	
	@Temporal(TemporalType.DATE)
	private Date CreationDate;
	
	/*public NotificationObject(Long ForumPostId, Long NewsFeedPostId, int type) {
	    this.ForumPostId = ForumPostId;
	    this.NewsFeedPostId = NewsFeedPostId;
	    this.type = type;
	    //CreationDate
	}*/

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Long getForumPostId() {return ForumPostId;}
	public void setForumPostId(Long forumPostId) {ForumPostId = forumPostId;}
	public Long getNewsFeedPostId() {return NewsFeedPostId;}
	public void setNewsFeedPostId(Long newsFeedPostId) {NewsFeedPostId = newsFeedPostId;}
	public int getType() {return type;}
	public void setType(int type) {this.type = type;}
	public Date getCreationDate() {return CreationDate;}
	public void setCreationDate(Date creationDate) {CreationDate = creationDate;}
}