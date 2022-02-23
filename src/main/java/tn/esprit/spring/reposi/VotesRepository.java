package tn.esprit.spring.reposi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Votes;
@Repository
public interface VotesRepository extends CrudRepository<Votes, Integer> {

}
