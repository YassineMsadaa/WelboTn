package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.BsUser;

public interface BsUserRepository extends CrudRepository<BsUser,Long> {
}
