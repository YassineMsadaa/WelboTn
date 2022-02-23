package tn.esprit.spring.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.spring.Entity.Collaborator;
import tn.esprit.spring.Entity.CollaboratorContact;

import java.util.List;

public interface ICollaboratorService {
    public Collaborator ajouterCollaborator(Collaborator collaborator);
    public void deleteCollaborator(Long collaboratorId);
    public List<Collaborator> getCollaborators();
    public Collaborator modifierCollaborator(Collaborator collaborator);
    public Collaborator getCollaborator(Long collaboratorId);
    
}
