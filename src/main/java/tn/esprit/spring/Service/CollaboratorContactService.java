package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.CollaboratorContact;
import tn.esprit.spring.Repository.CollaboratorContactRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CollaboratorContactService implements ICollaboratorContactService{
    @Autowired
    CollaboratorContactRepository collaboratorContactRepository;
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
}
