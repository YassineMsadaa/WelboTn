package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.ForumPosts;

public interface IForumPostsService {
	List<ForumPosts> retrieveAllForumPosts();
	ForumPosts  addForumPost(ForumPosts fp);
	void deleteForumPost(Long id);
	ForumPosts updateForumPost(ForumPosts fp);
//findTopByOrderByIdDesc
	List<ForumPosts> retrievePostByCateg(Long idcateg);
}
