package com.projecth.projecthbackend.politician.follow;

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
public class FollowEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long politicianId;

    public Follow toDto() {
        return new Follow(this.id, this.userId, this.politicianId);
    }

}
