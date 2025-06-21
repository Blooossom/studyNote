package blooossom.api.tag.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.tag.application.port.in.RegisterTagCommand;
import blooossom.api.tag.application.port.in.RegisterTagUseCase;
import blooossom.api.tag.application.port.out.RegisterTagPort;
import blooossom.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class RegisterTagService implements RegisterTagUseCase {

    private final RegisterTagPort registerTagPort;

    @Override
    public boolean registerTag(RegisterTagCommand command) {
        return registerTagPort.registerTag(Tag.of(command.id(), command.name()));
    }
}
