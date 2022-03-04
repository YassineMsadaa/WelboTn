package tn.esprit.spring.Service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.spring.Entity.BannedWords;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Repository.NewsFeedPostRepository;
import tn.esprit.spring.Repository.TagRepository;
import tn.esprit.spring.response.ResponseHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewFeedPostService implements INewsFeedPostService {
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    @Autowired
    NewsFeedPostRepository newsFeedPostRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    IBannedWordsService iBannedWordsService;

    public String checkForUnallowedwords(String text){
        String unallowedWords ="";
        List<BannedWords> bannedWords = iBannedWordsService.getBannedWordsList();
        for (BannedWords word : bannedWords){
            if( formattedString.contains(word.getWord())){
                allowed = false;
                unallowedWords = word.getWord() + ", "+unallowedWords;
            }
        }
    }
    @Override
    public ResponseEntity<Object> ajouterNewsfeedPost(NewsfeedPost newsfeedPost) {
        if(newsfeedPost.getContent().length() < 1){
            return ResponseHandler.generateResponse("Post content is empty", HttpStatus.MULTI_STATUS, newsfeedPost);
        }
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
                if(newsfeedPost.getImage().length()>0){
                    String fileextension = FilenameUtils.getExtension(Paths.get(newsfeedPost.getImage()).getFileName().toString()).toLowerCase();

                    if (fileextension.equals("png") || fileextension.equals("jpg") || fileextension.equals("jpeg") ){
                        newsfeedPost.setImage(uploadImgAndGetUrl(newsfeedPost.getImage()));

                    }else {
                        return ResponseHandler.generateResponse("file extension "+fileextension+" is not allowed this is the list of allowed extensions: [png, jpg, jpeg]", HttpStatus.MULTI_STATUS, null);
                    }

                }
                addedpost = newsFeedPostRepository.save(newsfeedPost);
                System.out.println(newsfeedPost.getImage());
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
        if (newsFeedPostRepository.findById(newsfeedPost.getId()).isEmpty()){
            return ResponseHandler.generateResponse("No record with this id", HttpStatus.MULTI_STATUS, null);

        }
        if(newsfeedPost.getContent().length() < 1){
            return ResponseHandler.generateResponse("Post content is empty", HttpStatus.MULTI_STATUS, newsfeedPost);
        }
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
        if (allowed) {
            try {
                newsfeedPost.setModifiedAt(LocalDateTime.now());
                return ResponseHandler.generateResponse("Successfully updated post", HttpStatus.OK, newsFeedPostRepository.save(newsfeedPost));
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }else{
        return ResponseHandler.generateResponse("You are not allowed to use "+unallowedWords, HttpStatus.MULTI_STATUS, null);
    }

    }

    @Override
    public ResponseEntity<Object> getNewsfeedPost(Long newsfeedPostId) {
        try{

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, newsFeedPostRepository.findById(newsfeedPostId).get());
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @Override
    public ResponseEntity<Object> getPostsByPostedBy(BsUser postedBy) {
        try{

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, newsFeedPostRepository.findByPostedby(postedBy));
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }
    public String uploadImgAndGetUrl(String imageUrlFromComputer) throws IOException {
        byte[] image = Files.readAllBytes(Paths.get(imageUrlFromComputer));
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        FileUtils.writeByteArrayToFile(new File("images/newsfeedposts/"+formattedDateTime+Paths.get(imageUrlFromComputer).getFileName()), image);
        return formattedDateTime+Paths.get(imageUrlFromComputer).getFileName().toString();//FilenameUtils.getExtension(Paths.get(imageUrlFromComputer).getFileName().toString());//ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/newsfeedposts/"+Paths.get(imageUrlFromComputer).getFileName()).toUriString();
    }


}
