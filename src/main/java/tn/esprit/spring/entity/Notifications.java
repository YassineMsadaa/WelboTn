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
	private int id; // Clé primaire
	
	private int NotificationObjectId;
	private int UserId;
	private Boolean Status;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getNotificationObjectId() {return NotificationObjectId;}
	public void setNotificationObjectId(int notificationObjectId) {	NotificationObjectId = notificationObjectId;}
	public int getUserId() {return UserId;}
	public void setUserId(int userId) {UserId = userId;}
	public Boolean getStatus() {return Status;}
	public void setStatus(Boolean status) {Status = status;}
}