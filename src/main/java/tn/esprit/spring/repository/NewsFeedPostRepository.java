package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Entity.NewsfeedPost;

import java.util.List;

@Repository
public interface NewsFeedPostRepository extends CrudRepository<NewsfeedPost,Long> {
    List<NewsfeedPost> findByPostedby(User postedBy);
    List<NewsfeedPost> findTop100ByOrderByIdDesc();
    NewsfeedPost findTopByOrderByIdDesc();
}
