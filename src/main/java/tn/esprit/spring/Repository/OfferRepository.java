package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.Offer;

public interface OfferRepository extends CrudRepository<Offer,Long> {
}
