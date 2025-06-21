package blooossom.api.tag.adapter.out;

import blooossom.api.global.annotations.Mapper;
import blooossom.api.tag.domain.Tag;

@Mapper
class TagMapper {

    TagJpaEntity mapToJpaEntity(Tag tag) {
        return new TagJpaEntity(tag.getId(), tag.getName());
    }

    Tag mapToDomainEntity(TagJpaEntity tag) {
        return Tag.of(tag.getId(), tag.getName());
    }
}
