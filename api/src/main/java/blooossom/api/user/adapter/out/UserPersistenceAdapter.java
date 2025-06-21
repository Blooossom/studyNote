package blooossom.api.user.adapter.out;

import blooossom.api.global.annotations.PersistenceAdapter;
import blooossom.api.user.application.port.out.LoadUserPort;
import blooossom.api.user.application.port.out.SignUpPort;
import blooossom.api.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@PersistenceAdapter
class UserPersistenceAdapter implements LoadUserPort, SignUpPort {

    private final UserJpaRepository userJpaRepository;

    private final UserMapper userMapper;

    @Override
    public Optional<User> loadUserById(String id) {
        UserJpaEntity jpaEntity = userJpaRepository.findByEmail(id);

        if (jpaEntity == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(userMapper.mapToDomainEntity(jpaEntity));
    }

    @Transactional
    @Override
    public boolean signUp(User user) {
        try {
           userJpaRepository.saveAndFlush(userMapper.mapToJpaEntity(user));
           return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
