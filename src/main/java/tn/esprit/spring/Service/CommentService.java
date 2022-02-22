package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Comment ajouterComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);

    }

    @Override
    public List<Comment> getComments() {

        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment modifierComment( Comment comment) {
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).get();
    }
}
