package blooossom.api.user.controller;

import blooossom.api.user.dto.UserRequest;
import blooossom.api.user.entity.User;
import blooossom.api.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @Operation(tags = {"findByEmail"})
    @GetMapping("")
    public ResponseEntity<User> getUser(@RequestParam String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @Operation(tags = {"signUp"})
    @PostMapping("")
    public ResponseEntity<Void> signUp(@RequestBody UserRequest.SignUpRequest user) {
        try {
            userService.signUp(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(tags = {"login"})
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserRequest.SignInRequest user) {
        return userService.signIn(user.getEmail(), user.getPassword())
                ? ResponseEntity.ok().build()
                : ResponseEntity.internalServerError().build();
    }

    @Operation(tags = {"changePw"})
    @PutMapping("")
    public ResponseEntity<Void> updatePwd(@RequestBody UserRequest.ChangePasswordRequest user) {
        return userService.changePassword(user)
                ? ResponseEntity.ok().build()
                : ResponseEntity.internalServerError().build();
    }

    @Operation(tags = {"signOut"})
    @DeleteMapping("")
    public ResponseEntity<Void> deleteUser(@RequestParam String email, @RequestParam String password) {
        try {
            userService.signOut(email, password);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
