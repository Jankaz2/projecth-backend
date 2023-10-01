package com.projecth.projecthbackend.politician;

import com.projecth.projecthbackend.politician.believes.CorePoliticalBelieves;
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

    @GetMapping("/{id}")
    public Politician getOne(@PathVariable Long id) {
        return politicianService.getPolitician(id);
    }

    @GetMapping
    public List<Politician> getAll() {
        return politicianService.getAll();
    }

}
