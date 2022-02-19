package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Tag;
import tn.esprit.spring.Service.ITagService;

import java.util.List;

@RestController
@RequestMapping(path ="/api/tags")
public class TagController {

    @Autowired
    ITagService iTagService;


   @GetMapping
   @RequestMapping(path ="/")
    public List<Tag> getTags(){
       return iTagService.getTags();
   }
   @GetMapping
   @RequestMapping(path = "/{id}")
   public Tag getTag(@RequestParam("id") Long id){
       return iTagService.getTag(id);
   }

   @PostMapping
   @RequestMapping(path = "new")
    public void add(Tag tag){
        iTagService.ajouterTag(tag);
    }

    @PostMapping
    @RequestMapping(path = "/edit")
    public void edit(Tag tag){
       iTagService.modifierTag(tag);
    }

    @DeleteMapping
    @RequestMapping(path = "/delete/{id}")
    public void delete(@RequestParam("id") Long id){
       iTagService.deleteTag(id);
    }

}
