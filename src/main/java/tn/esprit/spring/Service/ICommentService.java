package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.Entity.CollaboratorContact;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Tag;

import java.util.List;

public interface ICommentService {
    public Comment ajouterComment(Comment comment);
    public void deleteComment(Long commentId);
    public List<Comment> getComments();
    public Comment modifierComment(Comment comment);
    public Comment getComment(Long commentId);
    public ResponseEntity<List<Comment>> getCommentsByPost(Long postId);

}
