package blooossom.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginInfo {
    String email;
    String password;

    public void changePassword(String email, String password) {
        if (email == null || password == null) throw new NullPointerException();

        if (!validateEmail(email)) throw new IllegalArgumentException();

        this.password = password;
    }

    private boolean validateEmail(String email) {
        return this.email.equals(email);
    }
}
