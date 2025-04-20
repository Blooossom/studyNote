package blooossom.api.user.service;

import blooossom.api.user.dto.UserRequest;
import blooossom.api.user.entity.User;
import blooossom.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service(value = "userService")
public class UserService {

    private final UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void signUp(UserRequest.SignUpRequest user) {
        userRepository.saveAndFlush(user.toUser());
    }

    public Boolean signIn(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user.getPassword().equals(password);
    }

    public Boolean changePassword(UserRequest.ChangePasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail());

        if (!user.getPassword().equals(request.getOldPassword())) return false;

        user.setPassword(request.getNewPassword());

        userRepository.saveAndFlush(user);

        return true;
    }

    public void logOut(String email) {

    }

    public void signOut(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (!user.getPassword().equals(password)) return;

        userRepository.delete(user);
    }
}
