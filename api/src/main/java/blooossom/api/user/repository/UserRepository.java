package blooossom.api.user.repository;

import blooossom.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
