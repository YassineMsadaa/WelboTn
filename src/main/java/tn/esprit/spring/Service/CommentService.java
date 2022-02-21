package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Repository.CommentRepository;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Long ajouterComment(Comment comment) {
        commentRepository.save(comment);
        return comment.getId();
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
    public Long modifierComment( Comment comment) {
        commentRepository.save(comment);
        return comment.getId();
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).get();
    }
}
