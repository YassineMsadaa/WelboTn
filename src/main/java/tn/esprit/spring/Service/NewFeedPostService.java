package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.BannedWords;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Repository.NewsFeedPostRepository;
import tn.esprit.spring.Repository.TagRepository;
import tn.esprit.spring.response.ResponseHandler;

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
    @Autowired
    IBannedWordsService iBannedWordsService;
    @Override
    public ResponseEntity<Object> ajouterNewsfeedPost(NewsfeedPost newsfeedPost) {
        NewsfeedPost addedpost = new NewsfeedPost();
        boolean allowed = true;
        String unallowedWords ="";
        String originalString = newsfeedPost.getContent();
        String formattedString = originalString.toLowerCase();
        List<BannedWords> bannedWords = iBannedWordsService.getBannedWordsList();
        for (BannedWords word : bannedWords){
           if( formattedString.contains(word.getWord())){
                allowed = false;
                unallowedWords = word.getWord() + ", "+unallowedWords;
           }
        }
        if (allowed){
            newsfeedPost.setCreatedAt(LocalDateTime.now());
            newsfeedPost.setModifiedAt(LocalDateTime.now());
            try{
                addedpost = newsFeedPostRepository.save(newsfeedPost);
                return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, addedpost);
            }catch (Exception e){
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }else{
            return ResponseHandler.generateResponse("You are not allowed to use "+unallowedWords, HttpStatus.MULTI_STATUS, null);
        }
    }

    @Override
    public ResponseEntity<Object> deleteNewsfeedPost(Long newsfeedPostId) {
        try{
            newsFeedPostRepository.deleteById(newsfeedPostId);
            return ResponseHandler.generateResponse("Post successfully deleted !", HttpStatus.OK, null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    @Override
    public ResponseEntity<Object> getNewsfeedPosts() {
        try{
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, (List<NewsfeedPost>) newsFeedPostRepository.findAll());
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
       // return (List<NewsfeedPost>) newsFeedPostRepository.findAll();
    }

    @Override
    public List<NewsfeedPost> getLastPosts() {
        return newsFeedPostRepository.findTop100ByOrderByIdDesc();
    }

    @Override
    public NewsfeedPost getLastPost() {
        return newsFeedPostRepository.findTopByOrderByIdDesc();
    }

    @Override
    public ResponseEntity<Object> modifierNewsfeedPost(NewsfeedPost newsfeedPost) {

        try{
            newsfeedPost.setModifiedAt(LocalDateTime.now());
            return ResponseHandler.generateResponse("Successfully updated post", HttpStatus.OK, newsFeedPostRepository.save(newsfeedPost));
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
        //return newsfeedPost;
    }

    @Override
    public ResponseEntity<Object> getNewsfeedPost(Long newsfeedPostId) {
        try{

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, newsFeedPostRepository.findById(newsfeedPostId).get());
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
        //return newsFeedPostRepository.findById(newsfeedPostId).get();
    }

    @Override
    public ResponseEntity<Object> getPostsByPostedBy(BsUser postedBy) {
        try{

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, newsFeedPostRepository.findByPostedby(postedBy));
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
       // return newsFeedPostRepository.findByPostedby(postedBy);
    }


}
