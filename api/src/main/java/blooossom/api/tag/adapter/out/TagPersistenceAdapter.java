package blooossom.api.tag.adapter.out;

import blooossom.api.global.annotations.PersistenceAdapter;
import blooossom.api.tag.application.port.out.RegisterTagPort;
import blooossom.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@PersistenceAdapter
class TagPersistenceAdapter implements RegisterTagPort {

    private final TagJpaRepository tagJpaRepository;

    private final TagMapper tagMapper;

    @Override
    public boolean registerTag(Tag tag) {
        try {
            tagJpaRepository.save(tagMapper.mapToJpaEntity(tag));
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
