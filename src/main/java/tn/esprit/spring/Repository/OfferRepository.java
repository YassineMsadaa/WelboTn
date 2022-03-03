package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer,Long> {
}
