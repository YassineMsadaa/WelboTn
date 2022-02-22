package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Offer;

import java.util.List;

public interface IOfferService {
    public Offer ajouterOffer(Offer offer);
    public void deleteOffer(Long offerId);
    public List<Offer> getOffers();
    public Offer modifierOffer(Offer offer);
    public Offer getOffer(Long offerId);
}
