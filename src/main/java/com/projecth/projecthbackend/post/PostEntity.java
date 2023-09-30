package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.politician.PoliticianEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PostEntity {

    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PoliticianEntity politicianEntityId;

    private Long tagId;

    @Enumerated(EnumType.STRING)
    private PostType type;
    private String content;
    private Attitude attitude;
    private String videoPath;
    private int positive;
    private int negative;
    private int neutral;
}
