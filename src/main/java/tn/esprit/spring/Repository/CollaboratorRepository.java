package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Collaborator;
@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator,Long> {
}