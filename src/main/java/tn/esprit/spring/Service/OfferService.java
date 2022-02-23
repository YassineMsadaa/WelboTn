package tn.esprit.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Offer;
import tn.esprit.spring.Repository.OfferRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OfferService implements IOfferService{
    @Autowired
    OfferRepository offerRepository;
    @Override
    public Offer ajouterOffer(Offer offer) {
        offer.setState(false);
        offer.setCreatedAt(LocalDateTime.now());
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);

    }

    @Override
    public List<Offer> getOffers() {

        return (List<Offer>) offerRepository.findAll();
    }

    @Override
    public Offer modifierOffer( Offer offer) {

        offerRepository.save(offer);
        return offer;
    }

    @Override
    public Offer getOffer(Long offerId) {
        return offerRepository.findById(offerId).get();
    }

    @Override
    public Offer updateOfferState(Long offerId) {
        Offer offer = offerRepository.findById(offerId).get();
        offer.setState(!offer.getState());
        return offer;
    }
}
