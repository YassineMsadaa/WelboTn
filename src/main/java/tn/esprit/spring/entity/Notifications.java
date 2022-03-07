package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@SuppressWarnings("serial")

@Table( name = "Notifications")
public class Notifications implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id; // Clé primaire
	
	private Long NotificationObjectId;
	private Long UserId;
	private Boolean Status;
	
	public Notifications(Long NotificationObjectId, Long UserId) {
	    this.NotificationObjectId = NotificationObjectId;
	    this.UserId = UserId;
	    this.Status = false;
	}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public Long getNotificationObjectId() {return NotificationObjectId;}
	public void setNotificationObjectId(Long notificationObjectId) {	NotificationObjectId = notificationObjectId;}
	public Long getUserId() {return UserId;}
	public void setUserId(Long userId) {UserId = userId;}
	public Boolean getStatus() {return Status;}
	public void setStatus(Boolean status) {Status = status;}
}