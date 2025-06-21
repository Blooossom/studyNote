package blooossom.api.tag.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class Tag {
    String id;
    String name;

    public static Tag of(String id, String name) {
        return Tag.builder().id(id).name(name).build();
    }
}
