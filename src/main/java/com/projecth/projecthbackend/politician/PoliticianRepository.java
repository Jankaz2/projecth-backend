package com.projecth.projecthbackend.politician;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoliticianRepository extends JpaRepository<PoliticianEntity, Long> {

    Optional<PoliticianEntity> findByPoliticalParty(String politicianParty);

}
