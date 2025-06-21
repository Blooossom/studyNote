package blooossom.api.user.adapter.out;

import blooossom.api.global.annotations.Mapper;
import blooossom.api.user.domain.User;

@Mapper
class UserMapper {

    User mapToDomainEntity(UserJpaEntity user) {
        return User.of(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getPhone());
    }

    UserJpaEntity mapToJpaEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getName(),
                user.getLoginInfo().getEmail(),
                user.getLoginInfo().getPassword(),
                user.getPhone()
        );
    }
}
