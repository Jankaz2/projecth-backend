package com.projecth.projecthbackend.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long postId;
    private String content;
    private Attitude attitude;

    public Post toDto() {
        return new Post(this.id, this.postId, this.content, this.attitude);
    }

}
