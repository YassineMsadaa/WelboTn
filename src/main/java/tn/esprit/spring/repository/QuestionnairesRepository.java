package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Questionnaires;

@Repository
public interface QuestionnairesRepository extends CrudRepository <Questionnaires,Long>{

}
