package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.TypeDto;
import com.exo2.Exercice2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size)
    {
        return ResponseEntity.ok(typeService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(typeService.findById(id));
    }

    @GetMapping("/findBy")
    public ResponseEntity<TypeDto> findBy(@RequestParam String title) {
        return ResponseEntity.ok(typeService.findOneByTitle(title));
    }

    @PostMapping
    public ResponseEntity<TypeDto> save(@RequestBody TypeDto typeDto) {
        return ResponseEntity.ok(typeService.save(typeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDto> update(@PathVariable Long id, @RequestBody TypeDto typeDto) {
        return ResponseEntity.ok(typeService.update(id, typeDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
