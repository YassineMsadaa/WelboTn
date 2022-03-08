package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Entity.NewsfeedPost;

import java.util.List;

public interface INewsFeedPostService {
    public ResponseEntity<Object> ajouterNewsfeedPost(NewsfeedPost newsfeedPost);
    public ResponseEntity<Object> deleteNewsfeedPost(Long newsfeedPostId);
    public ResponseEntity<Object> getNewsfeedPosts();
    public List<NewsfeedPost> getLastPosts();
    public NewsfeedPost getLastPost();
    public ResponseEntity<Object> modifierNewsfeedPost(NewsfeedPost newsfeedPost);
    public ResponseEntity<Object> getNewsfeedPost(Long newsfeedPostId);
    public ResponseEntity<Object> getPostsByPostedBy(User postedBy);

}
