package blooossom.api.tag.adapter.out;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "tag", schema = "note")
class TagJpaEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
}
