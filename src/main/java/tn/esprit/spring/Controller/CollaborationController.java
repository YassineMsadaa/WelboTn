package tn.esprit.spring.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.*;
import tn.esprit.spring.Entity.Collaborator;
import tn.esprit.spring.Service.ICollaboratorContactService;
import tn.esprit.spring.Service.ICollaboratorService;
import tn.esprit.spring.Service.ICollaboratorService;
import tn.esprit.spring.Service.IOfferService;

import java.util.List;

@RestController
    @RequestMapping(path ="/api/collaborations")
public class CollaborationController {
    @Autowired
    ICollaboratorService iCollaboratorService;
    @Autowired
    ICollaboratorContactService iCollaboratorContactService;
    @Autowired
    IOfferService iOfferService;

    //CRUD Collaborator
    @GetMapping
    @RequestMapping(path ="/collaborators")
    public List<Collaborator> getCollaborators(){
        return iCollaboratorService.getCollaborators();
    }

    @GetMapping({"/collaborator/{id}"})
    public Collaborator getCollaborator(@PathVariable Long id){
        return iCollaboratorService.getCollaborator(id);
    }

    @PostMapping
    @RequestMapping(path = "/collaborator/new")
    @ResponseBody
    public Collaborator addCollaborator(@RequestBody Collaborator collaborator){
        return iCollaboratorService.ajouterCollaborator(collaborator);
    }

    @PutMapping
    @RequestMapping(path = "/collaborator/edit")
    @ResponseBody
    public Collaborator editCollaborator(@RequestBody Collaborator collaborator){
        return iCollaboratorService.modifierCollaborator(collaborator);
    }

    @DeleteMapping({"/collaborator/delete/{id}"})
    public void deleteCollaborator(@PathVariable Long id){
        iCollaboratorService.deleteCollaborator(id);
    }




    //CRUD Collaborator Contact
    @GetMapping
    @RequestMapping(path ="/collaborator/allcontacts")
    public List<CollaboratorContact> getCollaboratorContacts(){
        return iCollaboratorContactService.getCollaboratorContacts();
    }
    @GetMapping({"/collaborator/contact/{id}"})
    public CollaboratorContact getCollaboratorContact(@PathVariable Long id){
        return iCollaboratorContactService.getCollaboratorContact(id);
    }

    @PutMapping
    @RequestMapping(path = "/collaborator/contact/edit")
    @ResponseBody
    public CollaboratorContact edit(@RequestBody CollaboratorContact collaboratorContact){
        return iCollaboratorContactService.modifierCollaboratorContact(collaboratorContact);
    }

    @DeleteMapping({"/collaborator/contact/delete/{id}"})
    public void delete(@PathVariable Long id){
        iCollaboratorContactService.deleteCollaboratorContact(id);
    }
    //Add contact info to a collaborator
    @PostMapping("/collaborator/{collaboratorId}/contact/new")
    public ResponseEntity<CollaboratorContact> addcontactToCollaborator(@PathVariable(value = "collaboratorId") Long collaboratorId, @RequestBody CollaboratorContact contactRequest) {
        return   iCollaboratorContactService.addContactToCollaborator(collaboratorId,  contactRequest);
    }
    //Collaborator contact by collaborator
    @GetMapping("/collaborator/{collaboratorId}/contact/")
    public ResponseEntity<List<CollaboratorContact>> contactByCollaborator(@PathVariable(value = "collaboratorId") Long collaboratorId) {
        return   iCollaboratorContactService.getContactByCollaborator(collaboratorId);
    }



    //CRUD Offers

    @GetMapping
    @RequestMapping(path ="/offers")
    public List<Offer> getOffers(){
        return iOfferService.getOffers();
    }
    @GetMapping({"/offer/{id}"})
    public Offer getOffer(@PathVariable Long id){
        return iOfferService.getOffer(id);
    }

    @PostMapping
    @RequestMapping(path = "/offer/new")
    @ResponseBody
    public Offer addOffer(@RequestBody Offer offer){
        return iOfferService.ajouterOffer(offer);
    }

    @PutMapping
    @RequestMapping(path = "/offer/edit")
    @ResponseBody
    public Offer editOffer(@RequestBody Offer offer){
        return iOfferService.modifierOffer(offer);
    }

    @DeleteMapping({"/offer/delete/{id}"})
    public void deleteOffer(@PathVariable Long id){
        iOfferService.deleteOffer(id);
    }
}
