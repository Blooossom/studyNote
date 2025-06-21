package blooossom.api.tag.application.port.in;

import blooossom.api.tag.domain.Tag;

public interface GetTagInfoByIdQuery {
    Tag getTagById(String id);
}
