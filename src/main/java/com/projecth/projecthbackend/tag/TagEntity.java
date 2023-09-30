package com.projecth.projecthbackend.tag;

import com.projecth.projecthbackend.post.PostEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class TagEntity {

    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PostEntity post;
    private String name;

    public Tag toDto() {
        return new Tag(this.getId(), this.getPost().toDto(), this.getName());
    }
}
