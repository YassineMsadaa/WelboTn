package tn.esprit.spring.reposi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
