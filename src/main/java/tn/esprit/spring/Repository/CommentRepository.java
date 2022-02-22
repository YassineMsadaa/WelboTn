package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
}
