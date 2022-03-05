package tn.esprit.spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.ERole;
import tn.esprit.spring.Entity.Role;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
