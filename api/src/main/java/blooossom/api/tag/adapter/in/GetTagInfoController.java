package blooossom.api.tag.adapter.in;

import blooossom.api.global.annotations.WebAdapter;
import blooossom.api.tag.application.port.in.GetTagInfoByIdQuery;
import blooossom.api.tag.domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class GetTagInfoController {

    private final GetTagInfoByIdQuery getTagInfoByIdQuery;

    @GetMapping("/api/tag/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable String id) {
        return ResponseEntity.ok(getTagInfoByIdQuery.getTagById(id));
    }
}
