package blooossom.api.tag.application.service;

import blooossom.api.global.annotations.UseCase;
import blooossom.api.tag.application.port.in.GetTagInfoByIdQuery;
import blooossom.api.tag.application.port.out.LoadTagPort;
import blooossom.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class GetTagService implements GetTagInfoByIdQuery {

    private final LoadTagPort loadTagPort;

    @Override
    public Tag getTagById(String id) {
        return loadTagPort.loadTagById(id);
    }
}
