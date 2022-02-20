package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.NewsfeedPost;

import java.util.List;

public interface INewsFeedPostService {
    public Long ajouterNewsfeedPost(NewsfeedPost newsfeedPost);
    public void deleteNewsfeedPost(Long newsfeedPostId);
    public List<NewsfeedPost> getNewsfeedPosts();
    public Long modifierNewsfeedPost(NewsfeedPost newsfeedPost);
    public NewsfeedPost getNewsfeedPost(Long newsfeedPostId);
}
