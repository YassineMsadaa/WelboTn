package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.NewsfeedPost;

import javax.swing.event.ListDataEvent;
import java.util.List;

@Repository
public interface NewsFeedPostRepository extends CrudRepository<NewsfeedPost,Long> {
    List<NewsfeedPost> findByPostedby(BsUser postedBy);
    List<NewsfeedPost> findTop100ByOrderByIdDesc();
    NewsfeedPost findTopByOrderByIdDesc();
}
