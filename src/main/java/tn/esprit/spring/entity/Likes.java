package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@SuppressWarnings("serial")

@Table( name = "Likes")
public class Likes implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; // Clé primaire
	
	private Boolean LikeOrDislike; //1 == like; 0 == dislike
	private Long UserId;
	private Long ForumPostId;
	private Long NewsFeedPostId;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Long getUserId() {return UserId;}
	public void setUserId(Long userId) {UserId = userId;}
	public Long getForumPostId() {return ForumPostId;}
	public void setForumPostId(Long forumPostId) {ForumPostId = forumPostId;}
	public Long getNewsFeedPostId() {return NewsFeedPostId;}
	public void setNewsFeedPostId(Long newsFeedPostId) {NewsFeedPostId = newsFeedPostId;}
	public Boolean getLikeOrDislike() {return LikeOrDislike;}
	public void setLikeOrDislike(Boolean like) {LikeOrDislike = like;}
}
