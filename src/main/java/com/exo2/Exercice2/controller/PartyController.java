package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.PartyDto;
import com.exo2.Exercice2.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partys")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping
    public ResponseEntity<List<PartyDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size)
    {
        return ResponseEntity.ok(partyService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartyDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(partyService.findById(id));
    }

    @GetMapping("/findBy")
    public ResponseEntity<PartyDto> findBy(@RequestParam String nom, @RequestParam String prenom) {
        return ResponseEntity.ok(partyService.findOneByName(nom));
    }

    @PostMapping
    public ResponseEntity<PartyDto> save(@RequestBody PartyDto partyDto) {
        return ResponseEntity.ok(partyService.save(partyDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartyDto> update(@PathVariable Long id, @RequestBody PartyDto partyDto) {
        return ResponseEntity.ok(partyService.update(id, partyDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        partyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
