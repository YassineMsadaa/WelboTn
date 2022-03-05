package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Likes;
import tn.esprit.spring.entity.NotificationObject;
import tn.esprit.spring.entity.Notifications;
import tn.esprit.spring.service.ILikesService;

@RestController
@RequestMapping("/likes")
public class LikesController {
	@Autowired
	ILikesService LikesService;
	NotificationObject NotificationObject;
	Notifications Notifications;
	
	//http://localhost:8083/PIDEV/likes/retrieve-all-likes
	@GetMapping("/retrieve-all-likes")
	public List<Likes> getLikes() {
	List<Likes> listLikes = LikesService.retrieveAllLikes();
	return listLikes;
	}
	
	//http://localhost:8083/PIDEV/likes/add-like
	@PostMapping("/add-like")
	@ResponseBody
	public Likes addLike(@RequestBody Likes c)
	{
		Likes Like = LikesService.addLike(c);
		
		NotificationObject no = new NotificationObject();
		no.setForumPostId(c.getForumPostId());
		no.setNewsFeedPostId(c.getNewsFeedPostId());
		no.setType(2);
		//NO.setCreationDate(datetawa);
		
		LikesService.addobjnotif(no);
		
		
		
		Notifications N = new Notifications();
		N.setStatus(false);
		N.setUserId(c.getUserId());
		N.setNotificationObjectId(LikesService.findlastobj());
		
		LikesService.addNotification(N);
		
		return Like;
	}
	
	//http://localhost:8083/PIDEV/likes/remove-like/{id}
	@DeleteMapping("/remove-like/{id}")
	@ResponseBody
	public void removeLike(@PathVariable("id") Long id) {
		LikesService.deleteLike(id);
	}
	
	//http://localhost:8083/PIDEV/likes/modify-like
	@PutMapping("/modify-like")
	@ResponseBody
	public Likes modifyLike(@RequestBody Likes Like) {
	return LikesService.updateLike(Like);
	}
}
