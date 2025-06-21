package blooossom.api.tag.adapter.out;

import blooossom.api.global.annotations.PersistenceAdapter;
import blooossom.api.tag.application.port.out.LoadTagPort;
import blooossom.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class TagQueryAdapter implements LoadTagPort {

    private final TagMapper tagMapper;

    private final TagJpaRepository jpaRepository;

    @Override
    public Tag loadTagById(String id) {
        return tagMapper.mapToDomainEntity(jpaRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
