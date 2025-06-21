package blooossom.api.user.domain;

import blooossom.api.global.utils.IdGenerator;
import blooossom.api.user.application.port.in.SignUpCommand;
import blooossom.api.user.application.port.out.LoadUserPort;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private String id;
    private LoginInfo loginInfo;
    private String name;
    private String phone;

    public static User signUp(SignUpCommand command) {
        return User.builder()
                .id(IdGenerator.getUUID32())
                .loginInfo(new LoginInfo(command.getEmail(), command.getPassword()))
                .name(command.getUsername())
                .phone(command.getPhone())
                .build();
    }

    public boolean validateSignUp(LoadUserPort loadUserPort) {
        return loadUserPort.loadUserById(this.loginInfo.email).isEmpty();
    }

    public static User of(String id, String email, String password, String name, String phone) {
        return User.builder().id(id).loginInfo(new LoginInfo(email, password)).name(name).phone(phone).build();
    }
}
