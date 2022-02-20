package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Service.INewsFeedPostService;

import java.util.List;

@RestController
@RequestMapping(path ="/api/newsfeed")
public class NewsFeedPostController {
    @Autowired
    INewsFeedPostService iNewsFeedPostService;

    @GetMapping
    @RequestMapping(path ="/")
    public List<NewsfeedPost> getNewsFeedPosts(){
        return iNewsFeedPostService.getNewsfeedPosts();
    }
    @GetMapping
    @RequestMapping(path = "/{id}")
    public NewsfeedPost getNewsFeedPost(@RequestParam("id") Long id){
        return iNewsFeedPostService.getNewsfeedPost(id);
    }

    @PostMapping
    @RequestMapping(path = "new")
    public void add(NewsfeedPost newsFeedPost){
        iNewsFeedPostService.ajouterNewsfeedPost(newsFeedPost);
    }

    @PostMapping
    @RequestMapping(path = "/edit")
    public void edit(NewsfeedPost newsFeedPost){
        iNewsFeedPostService.modifierNewsfeedPost(newsFeedPost);
    }

    @DeleteMapping
    @RequestMapping(path = "/delete/{id}")
    public void delete(@RequestParam("id") Long id){
        iNewsFeedPostService.deleteNewsfeedPost(id);
    }


}
