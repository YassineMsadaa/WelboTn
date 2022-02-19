package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {

}
