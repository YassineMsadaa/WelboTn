package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.Collaborator;

public interface CollaboratorRepository extends CrudRepository<Collaborator,Long> {
}
