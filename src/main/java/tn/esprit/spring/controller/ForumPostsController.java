package tn.esprit.spring.controller;

import java.sql.Timestamp;
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

import tn.esprit.spring.entity.ForumPosts;
import tn.esprit.spring.service.IForumPostsService;

@RestController
@RequestMapping("/ForumPosts")
public class ForumPostsController {
	@Autowired
	IForumPostsService ForumPostsService;
	
	//http://localhost:8083/PIDEV/ForumPosts/retrieve-all-ForumPosts
	@GetMapping("/retrieve-all-ForumPosts")
	public List<ForumPosts> getForumPosts() {
	List<ForumPosts> listForumPosts = ForumPostsService.retrieveAllForumPosts();
	return listForumPosts;
	}
	
	//http://localhost:8083/PIDEV/ForumPosts/add-ForumPost
	@PostMapping("/add-ForumPost")
	@ResponseBody
	public ForumPosts addForumPost(@RequestBody ForumPosts c)
	{
		c.setUploadTime(new Timestamp(System.currentTimeMillis()));
		ForumPosts ForumPost = ForumPostsService.addForumPost(c);
		return ForumPost;
	}
	
	//http://localhost:8083/PIDEV/ForumPosts/remove-ForumPost/{id}
	@DeleteMapping("/remove-ForumPost/{id}")
	@ResponseBody
	public void removeForumPost(@PathVariable("id") Long id) {
		ForumPostsService.deleteForumPost(id);
	}
	
	//http://localhost:8083/PIDEV/ForumPosts/modify-ForumPost
	@PutMapping("/modify-ForumPost")
	@ResponseBody
	public ForumPosts modifyForumPost(@RequestBody ForumPosts ForumPost) {
	return ForumPostsService.updateForumPost(ForumPost);
	}
	
	//http://localhost:8083/PIDEV/ForumPosts/retrieve-ForumPosts-by-category/{idcateg}
		@GetMapping("/retrieve-ForumPosts-by-category/{idcateg}")
		public List<ForumPosts> getForumPostsByCategory(@PathVariable("idcateg") Long idcateg) {
		List<ForumPosts> listForumPosts = ForumPostsService.retrievePostByCateg(idcateg);
		return listForumPosts;
		}
}
