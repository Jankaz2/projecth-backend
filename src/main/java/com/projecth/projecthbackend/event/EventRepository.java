package com.projecth.projecthbackend.event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    EventEntity findByPoliticianEntityId(Long politicianId);

}
