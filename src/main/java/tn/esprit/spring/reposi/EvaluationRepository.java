package tn.esprit.spring.reposi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Evaluation;
@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {

}
