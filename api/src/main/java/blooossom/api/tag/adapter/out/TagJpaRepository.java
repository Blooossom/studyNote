package blooossom.api.tag.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TagJpaRepository extends JpaRepository<TagJpaEntity, String> {
}
