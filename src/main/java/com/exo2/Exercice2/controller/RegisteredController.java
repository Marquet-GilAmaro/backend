package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.composite.UserPartyComposite;
import com.exo2.Exercice2.dto.RegisteredDto;
import com.exo2.Exercice2.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registered")
public class RegisteredController {
    @Autowired
    private RegisteredService registeredService;

    @GetMapping
    public ResponseEntity<List<RegisteredDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(registeredService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisteredDto> findById(@PathVariable UserPartyComposite id) {
        return ResponseEntity.ok(registeredService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RegisteredDto> save(@RequestBody RegisteredDto registeredDto) {
        return ResponseEntity.ok(registeredService.save(registeredDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisteredDto> update(@PathVariable UserPartyComposite id, @RequestBody RegisteredDto registeredDto) {
        return ResponseEntity.ok(registeredService.update(id, registeredDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UserPartyComposite id) {
        registeredService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
