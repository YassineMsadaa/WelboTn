package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.BsUser;
import tn.esprit.spring.Entity.Offer;
import tn.esprit.spring.Entity.OfferReservation;

import java.util.List;

@Repository
public interface OfferReservationRepository extends CrudRepository<OfferReservation,Long> {
    List<OfferReservation> findAllByReservedBy(BsUser user);
    List<OfferReservation> findAllByOffer(Offer offer);
    Boolean existsAllByReservedByAndOffer(BsUser user, Offer offer);
}
