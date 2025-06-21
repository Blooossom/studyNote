package blooossom.api.tag.application.port.out;

import blooossom.api.tag.domain.Tag;

public interface LoadTagPort {

    Tag loadTagById(String id);
}
