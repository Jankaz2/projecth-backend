package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.politician.believes.CorePoliticalBelieves;
import com.projecth.projecthbackend.politician.response.PoliticianProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/politicians")
@RequiredArgsConstructor
public class PoliticianController {

    private final PoliticianService politicianService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Politician signUp(@RequestBody CreatePoliticianDto politician, @RequestParam MultipartFile file) {
        return politicianService.save(politician, file);
    }

    @GetMapping("/{politicianId}/{userId}")
    public PoliticianProfileResponse getOne(@PathVariable Long politicianId, @PathVariable Long userId) {
        return politicianService.getPolitician(politicianId, userId);
    }

    @GetMapping
    public List<Politician> getAll() {
        return politicianService.getAll();
    }

}
