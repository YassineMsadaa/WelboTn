package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Entity.Tag;
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
    public List<NewsfeedPost> getNewsFeedPosts(){
        return iNewsFeedPostService.getNewsfeedPosts();
    }

    @GetMapping({"/user/{userId}"})
    public List<NewsfeedPost> getNewsFeedPostsByUser(@PathVariable Long userId){
        BsUser user = new BsUser();
        user = iBsuserService.getBsUser(userId);

        return iNewsFeedPostService.getPostsByPostedBy(user);
    }

    @GetMapping({"/{id}"})
    public NewsfeedPost getNewsFeedPost(@PathVariable Long id){
        return iNewsFeedPostService.getNewsfeedPost(id);
    }

    @PostMapping
    @RequestMapping(path = "/new")
    @ResponseBody
    public NewsfeedPost add(@RequestBody NewsfeedPost newsFeedPost){
       return iNewsFeedPostService.ajouterNewsfeedPost(newsFeedPost);
    }

    @PutMapping
    @RequestMapping(path = "/edit")
    @ResponseBody
    public NewsfeedPost edit(@RequestBody NewsfeedPost newsFeedPost){
       return iNewsFeedPostService.modifierNewsfeedPost(newsFeedPost);
    }

    @DeleteMapping({"/delete/{id}"})
    public void delete(@PathVariable Long id){
        iNewsFeedPostService.deleteNewsfeedPost(id);
    }



}
