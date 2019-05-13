package chatapp.repositories;

import chatapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnap
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);    
}
