package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.Entity.BannedWords;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Service.IBannedWordsService;
import tn.esprit.spring.Service.IBsuserService;
import tn.esprit.spring.Service.INewsFeedPostService;

import java.util.List;

@RestController
@RequestMapping(path ="/api/newsfeed")
public class NewsFeedPostController {
    @Autowired
    INewsFeedPostService iNewsFeedPostService;
    @Autowired
    IBsuserService iBsuserService;


    @GetMapping
    public ResponseEntity<Object> getNewsFeedPosts(){
        return iNewsFeedPostService.getNewsfeedPosts();
    }

    @GetMapping({"/user/{userId}"})
    public ResponseEntity<Object> getNewsFeedPostsByUser(@PathVariable Long userId){
        BsUser user = new BsUser();
        user = iBsuserService.getBsUser(userId);

        return iNewsFeedPostService.getPostsByPostedBy(user);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getNewsFeedPost(@PathVariable Long id){
        return iNewsFeedPostService.getNewsfeedPost(id);
    }

    @PostMapping
    @RequestMapping(path = "/new")
    @ResponseBody
    public ResponseEntity<Object> add(@RequestBody NewsfeedPost newsFeedPost,@RequestParam("image") MultipartFile file){

       return iNewsFeedPostService.ajouterNewsfeedPost(newsFeedPost);
    }

    @PutMapping
    @RequestMapping(path = "/edit")
    @ResponseBody
    public ResponseEntity<Object> edit(@RequestBody NewsfeedPost newsFeedPost){
       return iNewsFeedPostService.modifierNewsfeedPost(newsFeedPost);
    }

    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return iNewsFeedPostService.deleteNewsfeedPost(id);
    }



}
