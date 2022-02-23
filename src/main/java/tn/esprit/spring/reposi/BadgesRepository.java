package tn.esprit.spring.reposi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Badges;

@Repository
public interface BadgesRepository extends CrudRepository<Badges, Integer> {

}
