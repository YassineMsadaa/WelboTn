package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.NewsfeedPost;

import java.util.List;

public interface INewsFeedPostService {
    public NewsfeedPost ajouterNewsfeedPost(NewsfeedPost newsfeedPost);
    public void deleteNewsfeedPost(Long newsfeedPostId);
    public List<NewsfeedPost> getNewsfeedPosts();
    public NewsfeedPost modifierNewsfeedPost(NewsfeedPost newsfeedPost);
    public NewsfeedPost getNewsfeedPost(Long newsfeedPostId);
}
