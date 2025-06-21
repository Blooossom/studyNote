package blooossom.api.user.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;


interface UserJpaRepository extends JpaRepository<UserJpaEntity, String> {
    UserJpaEntity findByEmail(String email);
}
