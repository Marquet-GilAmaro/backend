package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.InterestDto;
import com.exo2.Exercice2.entity.Interest;
import com.exo2.Exercice2.mapper.InterestMapper;
import com.exo2.Exercice2.repository.InterestRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class InterestService {
    private InterestRepository interestRepository;
    private InterestMapper interestMapper;

    @Cacheable(value = "interests", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public List<InterestDto> findAll(Pageable pageable) {
        return interestRepository.findAll(pageable).map(interestMapper::toDto).getContent();
    }

    @Cacheable(value = "interests", key = "#id")
    public InterestDto findById(long id) {
        return interestMapper.toDto(interestRepository.findById(id).orElse(null));
    }

    @Cacheable(value = "interests", key = "#title")
    public InterestDto findOneByTitle(String title) {
        return interestMapper.toDto(interestRepository.findInterestByTitle(title).orElse(null));
    }

    @CacheEvict(value = "interests", allEntries = true)
    public InterestDto save(InterestDto interestDto) {
        return interestMapper.toDto(interestRepository.save(interestMapper.toEntity(interestDto)));
    }

    @CacheEvict(value = "interests", allEntries = true)
   public InterestDto update(Long id, InterestDto typeDto) {
    return interestRepository.findById(id)
            .map(existingType -> {
                Interest type = interestMapper.toEntity(typeDto);
                type.setId(id);
                if (Objects.nonNull(existingType.getTitle())) {
                    type.setTitle(existingType.getTitle());
                }
                return interestMapper.toDto(interestRepository.save(type));
            })
            .orElse(null);
}

    @CacheEvict(value = {"interests"}, allEntries = true)
    public void delete(Long id) {
        interestRepository.deleteById(id);
    }
}

