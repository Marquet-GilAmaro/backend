package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.AdresseDto;
import com.exo2.Exercice2.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @GetMapping("/{id}")
    public ResponseEntity<AdresseDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(adresseService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AdresseDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size)
    {
        return ResponseEntity.ok(adresseService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<AdresseDto>> findBy(@RequestParam String ville,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(adresseService.findByVille(ville, PageRequest.of(page, size)));
    }
}