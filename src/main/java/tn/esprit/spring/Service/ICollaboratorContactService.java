package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.CollaboratorContact;

import java.util.List;

public interface ICollaboratorContactService {
    public CollaboratorContact ajouterCollaboratorContact(CollaboratorContact collaboratorContact);
    public void deleteCollaboratorContact(Long collaboratorContactId);
    public List<CollaboratorContact> getCollaboratorContacts();
    public CollaboratorContact modifierCollaboratorContact(CollaboratorContact collaboratorContact);
    public CollaboratorContact getCollaboratorContact(Long collaboratorContactId);
}
