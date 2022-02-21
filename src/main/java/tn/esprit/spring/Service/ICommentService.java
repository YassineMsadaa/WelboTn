package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Comment;

import java.util.List;

public interface ICommentService {
    public Long ajouterComment(Comment comment);
    public void deleteComment(Long commentId);
    public List<Comment> getComments();
    public Long modifierComment(Comment comment);
    public Comment getComment(Long commentId);
}
