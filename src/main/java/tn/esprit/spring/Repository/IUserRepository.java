package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
}
