package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Repository.NewsFeedPostRepository;
import tn.esprit.spring.Repository.TagRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewFeedPostService implements INewsFeedPostService {
    @Autowired
    NewsFeedPostRepository newsFeedPostRepository;
    @Autowired
    private TagRepository tagRepository;
    @Override
    public NewsfeedPost ajouterNewsfeedPost(NewsfeedPost newsfeedPost) {
        newsfeedPost.setCreatedAt(LocalDateTime.now());
        newsfeedPost.setModifiedAt(LocalDateTime.now());
        newsFeedPostRepository.save(newsfeedPost);
        return newsfeedPost;
    }

    @Override
    public void deleteNewsfeedPost(Long newsfeedPostId) {
        newsFeedPostRepository.deleteById(newsfeedPostId);
    }

    @Override
    public List<NewsfeedPost> getNewsfeedPosts() {

        return (List<NewsfeedPost>) newsFeedPostRepository.findAll();
    }

    @Override
    public NewsfeedPost modifierNewsfeedPost(NewsfeedPost newsfeedPost) {
        newsfeedPost.setModifiedAt(LocalDateTime.now());
        newsFeedPostRepository.save(newsfeedPost);
        return newsfeedPost;
    }

    @Override
    public NewsfeedPost getNewsfeedPost(Long newsfeedPostId) {
        return newsFeedPostRepository.findById(newsfeedPostId).get();
    }

    @Override
    public List<NewsfeedPost> getPostsByPostedBy(BsUser postedBy) {
        return newsFeedPostRepository.findByPostedby(postedBy);
    }


}
