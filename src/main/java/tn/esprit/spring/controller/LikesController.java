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
import tn.esprit.spring.service.ILikesService;

@RestController
@RequestMapping("/Likes")
public class LikesController {
	@Autowired
	ILikesService LikesService;
	
	//http://localhost:8083/PIDEV/Likes/retrieve-all-Like
	@GetMapping("/retrieve-all-Likes")
	public List<Likes> getLikes() {
	List<Likes> listLikes = LikesService.retrieveAllLikes();
	return listLikes;
	}
	
	//http://localhost:8083/PIDEV/Likes/add-Like
	@PostMapping("/add-Likes")
	@ResponseBody
	public Likes addLike(@RequestBody Likes c)
	{
		Likes Like = LikesService.addLike(c);
		return Like;
	}
	
	//http://localhost:8083/PIDEV/Likes/remove-Like/{id}
	@DeleteMapping("/remove-Like/{id}")
	@ResponseBody
	public void removeLike(@PathVariable("id") Long id) {
		LikesService.deleteLike(id);
	}
	
	//http://localhost:8083/PIDEV/Likes/modify-Like
	@PutMapping("/modify-Likes")
	@ResponseBody
	public Likes modifyLike(@RequestBody Likes Like) {
	return LikesService.updateLike(Like);
	}
}
