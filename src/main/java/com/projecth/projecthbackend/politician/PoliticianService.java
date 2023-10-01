package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.common.PhotoService;
import com.projecth.projecthbackend.common.S3Path;
import com.projecth.projecthbackend.event.Event;
import com.projecth.projecthbackend.event.EventEntity;
import com.projecth.projecthbackend.event.EventRepository;
import com.projecth.projecthbackend.politician.believes.CorePoliticalBelieves;
import com.projecth.projecthbackend.politician.believes.CorePoliticalBelievesRepository;
import com.projecth.projecthbackend.politician.response.PoliticianProfileResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PoliticianService {

    private final PhotoService photoService;
    private final PoliticianRepository politicianRepository;
    private final EventRepository eventRepository;

    @Transactional
    public Politician save(CreatePoliticianDto politician, MultipartFile profilePhoto) {
        var savedPolitician = politicianRepository.save(politician.toPoliticianEntity());
        var path = S3Path.PROFILE.name() + "/" + savedPolitician.getId() + "_" + savedPolitician.getName() + "_" + savedPolitician.getSurname();
        photoService.uploadFile(profilePhoto, path);

        return savedPolitician.toDto();
    }

    @Transactional
    public PoliticianProfileResponse getPolitician(Long politicianId) {
        String eventName = eventRepository.findByPoliticianEntityId(politicianId).toDto().name();
        Politician politician = politicianRepository.findById(politicianId)
                .orElseThrow(() -> new RuntimeException("Politician with this id [" + politicianId + "] has not been found"))
                .toDto();
        return new PoliticianProfileResponse(politician.id(), politician.name(), politician.surname(), politician.bio(), politician.politicalParty(),
                politician.profilePhotoPath(), politician.backgroundPhotoPath(), politician.corePoliticalBelieves(), eventName);
    }

    @Transactional
    public List<Politician> getAll() {
        return politicianRepository.findAll().stream().map(PoliticianEntity::toDto).toList();
    }
}
