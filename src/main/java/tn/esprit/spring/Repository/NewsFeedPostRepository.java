package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.NewsfeedPost;


public interface NewsFeedPostRepository extends CrudRepository<NewsfeedPost,Long> {
}
