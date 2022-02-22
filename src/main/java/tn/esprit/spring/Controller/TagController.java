package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Repository.NewsFeedPostRepository;
import tn.esprit.spring.Repository.TagRepository;
import tn.esprit.spring.Service.ITagService;

import java.util.List;

@RestController
@RequestMapping(path ="/api/tags")
public class TagController {

    @Autowired
    ITagService iTagService;
    @Autowired
    NewsFeedPostRepository newsFeedPostRepository;
    @Autowired
    private TagRepository tagRepository;


   @GetMapping
   @RequestMapping(path ="/")
    public List<Tag> getTags(){
       return iTagService.getTags();
   }

    @GetMapping({"/{id}"})
   public Tag getTag(@PathVariable Long id){
       return iTagService.getTag(id);
   }

    @PostMapping
    @RequestMapping(path = "/new")
    @ResponseBody
    public Tag add(@RequestBody Tag tag){

        return iTagService.ajouterTag(tag);
    }

    @PutMapping
    @RequestMapping(path = "/edit")
    @ResponseBody
    public Tag edit(@RequestBody Tag tag){
       return iTagService.modifierTag(tag);
    }

    @DeleteMapping({"/delete/{id}"})
    public void delete(@PathVariable Long id){
       iTagService.deleteTag(id);
    }
    @PostMapping("/NewsfeedPosts/{NewsfeedPostId}/tags")
    public ResponseEntity<Tag> addTag(@PathVariable(value = "NewsfeedPostId") Long NewsfeedPostId, @RequestBody Tag tagRequest) {
        Tag tag = newsFeedPostRepository.findById(NewsfeedPostId).map(NewsfeedPost -> {

            long tagId = tagRequest.getId();

            // tag is existed
            if (tagId != 0L) {
                Tag _tag = tagRepository.findById(tagId).get();
                NewsfeedPost.addTag(_tag);
                newsFeedPostRepository.save(NewsfeedPost);
                return _tag;
            }

            // add and create new Tag
            NewsfeedPost.addTag(tagRequest);
            return tagRepository.save(tagRequest);
        }).get();
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }
    @PostMapping("/NewsfeedPosts1/{NewsfeedPostId}/tags")
    public ResponseEntity<Tag> addTag1(@PathVariable(value = "NewsfeedPostId") Long NewsfeedPostId, @RequestBody List<Tag> tagRequest) {
       Tag tag = new Tag();
        for (Tag tag12 : tagRequest){
        tag = newsFeedPostRepository.findById(NewsfeedPostId).map(NewsfeedPost -> {

                long tagId = tag12.getId();
                // tag is existed
                if (tagId != 0L) {
                    Tag _tag = tagRepository.findById(tagId).get();
                    NewsfeedPost.addTag(_tag);
                    newsFeedPostRepository.save(NewsfeedPost);
                    return _tag;
                }
                // add and create new Tag
                NewsfeedPost.addTag(tag12);


            return tagRepository.save(tag12);
        }).get();
        }
        return new ResponseEntity<>(tag, HttpStatus.CREATED); 
    }

}
