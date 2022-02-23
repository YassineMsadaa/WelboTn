package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.CollaboratorContact;
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
    @GetMapping({"/{id}"})
    public Comment getComment(@PathVariable Long id){
        return iCommentService.getComment(id);
    }

    @PostMapping
    @RequestMapping(path = "/new")
    @ResponseBody
    public Comment add(@RequestBody Comment comment){
        return iCommentService.ajouterComment(comment);
    }

    @PutMapping
    @RequestMapping(path = "/edit")
    @ResponseBody
    public Comment edit(@RequestBody Comment comment){
        return iCommentService.modifierComment(comment);
    }

    @DeleteMapping({"/delete/{id}"})
    public void delete(@PathVariable Long id){
        iCommentService.deleteComment(id);
    }

    // comments by post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> commentByPost(@PathVariable(value = "postId") Long postId) {
        return   iCommentService.getCommentsByPost(postId);
    }
}
