package blooossom.api.user.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.user.application.port.in.SignUpCommand;
import blooossom.api.user.application.port.in.SignUpUseCase;
import blooossom.api.user.application.port.out.LoadUserPort;
import blooossom.api.user.application.port.out.SignUpPort;
import blooossom.api.user.domain.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@UseCase
public class SignUpService implements SignUpUseCase {

    private final LoadUserPort loadUserPort;

    private final SignUpPort signUpPort;

    @Override
    public boolean signUp(SignUpCommand command) {
        User signUp = User.signUp(command);

        if (!signUp.validateSignUp(loadUserPort)) throw new RuntimeException();

        return signUpPort.signUp(signUp);
    }
}
