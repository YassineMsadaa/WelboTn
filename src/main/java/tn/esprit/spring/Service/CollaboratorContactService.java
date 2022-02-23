package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Collaborator;
import tn.esprit.spring.Entity.CollaboratorContact;
import tn.esprit.spring.Repository.CollaboratorContactRepository;
import tn.esprit.spring.Repository.CollaboratorRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CollaboratorContactService implements ICollaboratorContactService{
    @Autowired
    CollaboratorContactRepository collaboratorContactRepository;
    @Autowired
    CollaboratorRepository collaboratorRepository;
    @Override
    public CollaboratorContact ajouterCollaboratorContact(CollaboratorContact collaboratorContact) {

        collaboratorContactRepository.save(collaboratorContact);
        return collaboratorContact;
    }

    @Override
    public void deleteCollaboratorContact(Long collaboratorContactId) {
        collaboratorContactRepository.deleteById(collaboratorContactId);

    }

    @Override
    public List<CollaboratorContact> getCollaboratorContacts() {

        return (List<CollaboratorContact>) collaboratorContactRepository.findAll();
    }

    @Override
    public CollaboratorContact modifierCollaboratorContact( CollaboratorContact collaboratorContact) {
        collaboratorContactRepository.save(collaboratorContact);
        return collaboratorContact;
    }

    @Override
    public CollaboratorContact getCollaboratorContact(Long collaboratorContactId) {
        return collaboratorContactRepository.findById(collaboratorContactId).get();
    }

    @Override
    public ResponseEntity<CollaboratorContact> addContactToCollaborator(Long collaboratorId, CollaboratorContact collaboratorContact) {
        Collaborator collaborator = collaboratorRepository.findById(collaboratorId).get();
        collaboratorContact.setCollaborator(collaborator);
        collaboratorContactRepository.save(collaboratorContact);
        return new ResponseEntity<>(collaboratorContact, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CollaboratorContact>> getContactByCollaborator(Long collaboratorId) {
        Collaborator collaborator = collaboratorRepository.findById(collaboratorId).get();
        return new ResponseEntity<>(collaboratorContactRepository.findByCollaborator(collaborator), HttpStatus.CREATED);
    }
}
