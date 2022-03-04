package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.Entity.CollaboratorContact;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Tag;

import java.util.List;

public interface ICommentService {
    public ResponseEntity<Object> ajouterComment(Comment comment);
    public ResponseEntity<Object> deleteComment(Long commentId);
    public ResponseEntity<Object> getComments();
    public ResponseEntity<Object> modifierComment(Comment comment);
    public ResponseEntity<Object> getComment(Long commentId);
    public ResponseEntity<Object> getCommentsByPost(Long postId);

}
