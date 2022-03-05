package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Likes;
import tn.esprit.spring.entity.NotificationObject;
import tn.esprit.spring.entity.Notifications;

public interface ILikesService {
	List<Likes> retrieveAllLikes();
	Likes  addLike(Likes l);
	void deleteLike(Long id);
	Likes updateLike(Likes l);
	void addobjnotif(NotificationObject no);
	void addNotification(Notifications no);
	Long findlastobj();
}