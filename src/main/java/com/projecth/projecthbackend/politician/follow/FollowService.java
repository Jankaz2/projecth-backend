package com.projecth.projecthbackend.politician.follow;

import com.projecth.projecthbackend.politician.Politician;
import com.projecth.projecthbackend.politician.PoliticianEntity;
import com.projecth.projecthbackend.politician.PoliticianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final PoliticianRepository politicianRepository;

    public List<FollowedResponse> getFollowedPoliticsByUser(Long userId) {

        List<FollowEntity> ids = followRepository.findByUserId(userId);
        return ids.stream().map(id -> {
            PoliticianEntity politicianEntity = politicianRepository.findById(id.getPoliticianId()).orElse(null);
            if (politicianEntity == null) {
                return null;
            } else {
                Politician politician = politicianEntity.toDto();
                return new FollowedResponse(politician.id(), politician.name(), politician.name(), politician.profilePhotoPath());
            }
        }).toList();

    }

}
