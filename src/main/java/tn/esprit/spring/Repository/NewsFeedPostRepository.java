package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.NewsfeedPost;

@Repository
public interface NewsFeedPostRepository extends CrudRepository<NewsfeedPost,Long> {
}
