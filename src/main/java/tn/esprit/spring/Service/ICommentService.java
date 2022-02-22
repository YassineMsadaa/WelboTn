package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Tag;

import java.util.List;

public interface ICommentService {
    public Comment ajouterComment(Comment comment);
    public void deleteComment(Long commentId);
    public List<Comment> getComments();
    public Comment modifierComment(Comment comment);
    public Comment getComment(Long commentId);
}
