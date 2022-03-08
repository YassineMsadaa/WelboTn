package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.User;
@Repository
public interface BsUserRepository extends CrudRepository<User,Long> {
}
