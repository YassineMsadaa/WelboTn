package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Service.ICommentService;

import java.util.List;

@RestController
@RequestMapping(path ="/api/comments")
public class CommentController {

    @Autowired
    ICommentService iCommentService;


    @GetMapping
    @RequestMapping(path ="/")
    public List<Comment> getComments(){
        return iCommentService.getComments();
    }
    @GetMapping
    @RequestMapping(path = "/{id}")
    public Comment getComment(@RequestParam("id") Long id){
        return iCommentService.getComment(id);
    }

    @PostMapping
    @RequestMapping(path = "/new")
    public void add(Comment comment){
        iCommentService.ajouterComment(comment);
    }

    @PostMapping
    @RequestMapping(path = "/edit")
    public void edit(Comment comment){
        iCommentService.modifierComment(comment);
    }

    @DeleteMapping
    @RequestMapping(path = "/delete/{id}")
    public void delete(@RequestParam("id") Long id){
        iCommentService.deleteComment(id);
    }
}
