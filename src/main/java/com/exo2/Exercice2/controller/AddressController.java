package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.AddressDto;
import com.exo2.Exercice2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size)
    {
        return ResponseEntity.ok(addressService.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<AddressDto>> findBy(@RequestParam String ville,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(addressService.findByVille(ville, PageRequest.of(page, size)));
    }
}
