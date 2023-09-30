package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.common.PhotoService;
import com.projecth.projecthbackend.common.S3Path;
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

    @Transactional
    public Politician save(CreatePoliticianDto politician, MultipartFile profilePhoto) {
        var savedPolitician = politicianRepository.save(politician.toPoliticianEntity());
        var path = S3Path.PROFILE.name() + "/" + savedPolitician.getId() + "_" + savedPolitician.getName() + "_" + savedPolitician.getSurname();
        photoService.uploadFile(profilePhoto, path);

        return savedPolitician.toDto();
    }

    @Transactional
    public Politician getPolitician(Long id) {
        return politicianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Politician with this id [" + id + "] has not been found"))
                .toDto();
    }

    @Transactional
    public List<Politician> getAll() {
        return politicianRepository.findAll().stream().map(PoliticianEntity::toDto).toList();
    }
}
