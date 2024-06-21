package com.exo2.Exercice2.service;

import com.exo2.Exercice2.composite.UserPartyComposite;
import com.exo2.Exercice2.dto.RegisteredDto;
import com.exo2.Exercice2.entity.Registered;
import com.exo2.Exercice2.mapper.RegisteredMapper;
import com.exo2.Exercice2.repository.RegisteredRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisteredService {
    private RegisteredRepository registeredRepository;
    private RegisteredMapper registeredMapper;

    @Cacheable(value = "registered", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public List<RegisteredDto> findAll(Pageable pageable) {
        return registeredRepository.findAll(pageable).map(registeredMapper::toDto).getContent();
    }

    @Cacheable(value = "registered", key = "#id")
    public RegisteredDto findById(UserPartyComposite id) {
        return registeredMapper.toDto(registeredRepository.findById(id).orElse(null));
    }

    @CacheEvict(value = "registered", allEntries = true)
    public RegisteredDto save(RegisteredDto registeredDto) {
        return registeredMapper.toDto(registeredRepository.save(registeredMapper.toEntity(registeredDto)));
    }

    @CacheEvict(value = "registered", allEntries = true)
    public RegisteredDto update(UserPartyComposite id, RegisteredDto registeredDto) {
        Registered registered = registeredRepository.findById(id).orElse(null);
        if (registered == null) {
            return null;
        }
        return registeredMapper.toDto(registeredRepository.save(registered));
    }

    @CacheEvict(value = {"registered"}, allEntries = true)
    public void delete(UserPartyComposite id) {
        registeredRepository.deleteById(id);
    }
}

