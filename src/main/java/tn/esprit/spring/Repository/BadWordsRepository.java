package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.BannedWords;
import tn.esprit.spring.Entity.CollaboratorContact;

public interface BadWordsRepository extends CrudRepository<BannedWords,Long> {
}
