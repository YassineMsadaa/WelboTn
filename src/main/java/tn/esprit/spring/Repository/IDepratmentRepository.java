package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.Departement;

public interface IDepratmentRepository extends CrudRepository<Departement, Long> {
}
