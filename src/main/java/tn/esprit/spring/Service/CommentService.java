package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Collaborator;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.NewsfeedPost;
import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.NewsFeedPostRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    NewsFeedPostRepository newsFeedPostRepository;
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

    @Override
    public ResponseEntity<List<Comment>> getCommentsByPost(Long postId) {
        NewsfeedPost post = newsFeedPostRepository.findById(postId).get();
        return new ResponseEntity<>(commentRepository.findByNewsfeedPost(post), HttpStatus.CREATED);
    }
}
