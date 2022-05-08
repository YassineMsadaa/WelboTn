package tn.esprit.spring.reposi;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public User findUserByUserName(String userName);
    Optional<User> findByName(String name);
    public User findUserByName(String name);
    public User findUserByEmail(String email);
    public boolean existsByEmail(String email);
    Boolean existsById(String id);
    Boolean existsByUserName(String username);
    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);
	public Optional<User> findById(Long id);
	public void deleteById(Long id);



}
