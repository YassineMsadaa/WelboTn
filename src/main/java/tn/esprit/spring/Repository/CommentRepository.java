package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.Comment;


public interface CommentRepository extends CrudRepository<Comment,Long> {
}
