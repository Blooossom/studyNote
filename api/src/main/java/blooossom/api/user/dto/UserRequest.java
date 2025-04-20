package blooossom.api.user.dto;

import blooossom.api.global.utils.IdGenerator;
import blooossom.api.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserRequest {

    @Data
    @AllArgsConstructor
    public static class SignUpRequest {
        private String username;
        private String password;
        private String email;
        private String phone;

        public User toUser() {
            return new User(IdGenerator.getUUID64(), username, password, email, phone);
        }
    }

    @Data
    @AllArgsConstructor
    public static class SignInRequest {
        private String email;
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class ChangePasswordRequest {
        private String email;
        private String oldPassword;
        private String newPassword;
        private String confirmPassword;
    }
}
