package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.Collaborator;
import tn.esprit.spring.Entity.CollaboratorContact;
import tn.esprit.spring.Entity.NewsfeedPost;

import java.util.List;
@Repository
public interface CollaboratorContactRepository extends CrudRepository<CollaboratorContact,Long> {
    List<CollaboratorContact> findByCollaborator(Collaborator collaborator);
}
