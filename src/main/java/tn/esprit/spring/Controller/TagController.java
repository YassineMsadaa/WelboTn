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

}
