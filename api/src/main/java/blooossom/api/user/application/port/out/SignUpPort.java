package blooossom.api.user.application.port.out;

import blooossom.api.user.domain.User;

public interface SignUpPort {

    boolean signUp(User user);
}
