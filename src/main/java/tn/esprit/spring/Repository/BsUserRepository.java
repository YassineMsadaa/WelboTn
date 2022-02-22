package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.BsUser;
@Repository
public interface BsUserRepository extends CrudRepository<BsUser,Long> {
}
