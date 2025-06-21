package blooossom.api.user.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpCommand {

    private String username;
    private String password;
    private String email;
    private String phone;
}
