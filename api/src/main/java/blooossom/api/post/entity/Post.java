package blooossom.api.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "post", schema = "note")
public class Post {

    @Id
    @Column(name = "id")
    private String id;

    @Setter
    @Column(name = "title")
    private String title;

    @Setter
    @Column(name = "content")
    private String content;

    @Column(name = "createdTime")
    private LocalDateTime createdTime;

    @Setter
    @Column(name = "modifiedTime")
    private LocalDateTime modifiedTime;
}
