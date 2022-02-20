package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Repository.NewsFeedPostRepository;
import tn.esprit.spring.Repository.TagRepository;

import java.util.List;

@Service
public class NewFeedPostService implements INewsFeedPostService {
    @Autowired
    NewsFeedPostRepository newsFeedPostRepository;
    @Override
    public Long ajouterNewsfeedPost(NewsfeedPost newsfeedPost) {
        newsFeedPostRepository.save(newsfeedPost);
        return newsfeedPost.getId();
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
    public Long modifierNewsfeedPost(NewsfeedPost newsfeedPost) {
        newsFeedPostRepository.save(newsfeedPost);
        return newsfeedPost.getId();
    }

    @Override
    public NewsfeedPost getNewsfeedPost(Long newsfeedPostId) {
        return newsFeedPostRepository.findById(newsfeedPostId).get();
    }
}
