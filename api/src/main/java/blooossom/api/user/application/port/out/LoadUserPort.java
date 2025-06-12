package blooossom.api.user.application.port.out;

import blooossom.api.user.domain.User;

import java.util.Optional;

public interface LoadUserPort {
    Optional<User> loadUserById(String id);
}
