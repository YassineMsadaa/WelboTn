package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.Message;

public interface IMessageRepository extends CrudRepository<Message, Integer> {
}
