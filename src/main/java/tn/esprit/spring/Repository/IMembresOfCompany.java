package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.Entity.MembersOfCompany;

public interface IMembresOfCompany extends CrudRepository<MembersOfCompany,Long> {

    boolean existsByNid(String nid);
}
