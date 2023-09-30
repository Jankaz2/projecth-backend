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

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private PoliticianEntity politicianEntity;

    @Enumerated(EnumType.STRING)
    private PostType type;
    private String content;
    private String videoPath;
    private int positiveVotes;
    private int negativeVotes;
    private int neutralVotes;

    public Post toDto() {
        return new Post(this.id, this.politicianEntity.toDto(), this.type, this.content, this.videoPath, this.positiveVotes, this.negativeVotes, this.neutralVotes);
    }
}
