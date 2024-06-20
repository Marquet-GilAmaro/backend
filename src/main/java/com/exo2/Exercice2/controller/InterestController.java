package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.InterestDto;
import com.exo2.Exercice2.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interests")
public class InterestController {

    @Autowired
    private InterestService interestService;

    @GetMapping
    public ResponseEntity<List<InterestDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size)
    {
        return ResponseEntity.ok(interestService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterestDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(interestService.findById(id));
    }

    @GetMapping("/findBy")
    public ResponseEntity<InterestDto> findBy(@RequestParam String title) {
        return ResponseEntity.ok(interestService.findOneByTitle(title));
    }

    @PostMapping
    public ResponseEntity<InterestDto> save(@RequestBody InterestDto interestDto) {
        return ResponseEntity.ok(interestService.save(interestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterestDto> update(@PathVariable Long id, @RequestBody InterestDto interestDto) {
        return ResponseEntity.ok(interestService.update(id, interestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
