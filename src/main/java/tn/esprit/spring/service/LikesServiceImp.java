package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Likes;
import tn.esprit.spring.entity.NotificationObject;
import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.repository.LikesRepository;

@Service
public class LikesServiceImp implements ILikesService{
	@Autowired
	LikesRepository LikesRepository;

	@Override
	public List<Likes> retrieveAllLikes() {
		List<Likes> Likes = (List<Likes>) LikesRepository.findAll();
		return Likes;
	}

	@Override
	public Likes addLike(Likes l) {
		
		/*NotificationObject no = new NotificationObject();
		no.setForumPostId(c.getForumPostId());
		no.setNewsFeedPostId(c.getNewsFeedPostId());
		no.setType(2);*/
		
		//System.out.println("id from no: "+no.getId()+" | forumpostid from no: "+no.getForumPostId()+" | NewsFeedPostId from no: "+no.getNewsFeedPostId()+" | Type from no: "+no.getType());

		LikesRepository.save(l);
		 return l;
	}

	@Override
	public void deleteLike(Long id) {
		LikesRepository.delete(LikesRepository.findById(id).get());
	}

	@Override
	public Likes updateLike(Likes l) {
		return LikesRepository.save(l);
	}

	@Override
	public void addobjnotif(NotificationObject no) {
		LikesRepository.insertnotifobj(no.getForumPostId(), no.getNewsFeedPostId(), no.getType());
	}

	@Override
	public void addNotification(Notifications n) {
		LikesRepository.insertnotification(n.getNotificationObjectId(), n.getStatus(), n.getUserId());
	}

	@Override
	public Long findlastobj() {
		Long n = LikesRepository.retrieveLastNotificationObjectId();
		return n;
	}

	/*
	@Override
	public List<NotificationObject> findlastobj() {
		List<NotificationObject> n = LikesRepository.retrieveLastNotificationObjectId();
		return n;
	}*/
}
