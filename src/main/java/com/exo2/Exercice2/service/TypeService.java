package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.TypeDto;
import com.exo2.Exercice2.entity.Type;
import com.exo2.Exercice2.mapper.TypeMapper;
import com.exo2.Exercice2.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TypeService {
    private TypeRepository typeRepository;
    private TypeMapper typeMapper;

    @Cacheable(value = "types", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public List<TypeDto> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable).map(typeMapper::toDto).getContent();
    }

    @Cacheable(value = "types", key = "#id")
    public TypeDto findById(long id) {
        return typeMapper.toDto(typeRepository.findById(id).orElse(null));
    }

    @Cacheable(value = "types", key = "#title")
    public TypeDto findOneByTitle(String title) {
        return typeMapper.toDto(typeRepository.findTypeByTitle(title).orElse(null));
    }

    @CacheEvict(value = "types", allEntries = true)
    public TypeDto save(TypeDto typeDto) {
        return typeMapper.toDto(typeRepository.save(typeMapper.toEntity(typeDto)));
    }

   public TypeDto update(Long id, TypeDto typeDto) {
    return typeRepository.findById(id)
            .map(existingType -> {
                Type type = typeMapper.toEntity(typeDto);
                type.setId(id);
                if (Objects.nonNull(existingType.getTitle())) {
                    type.setTitle(existingType.getTitle());
                }
                return typeMapper.toDto(typeRepository.save(type));
            })
            .orElse(null);
}

    @CacheEvict(value = {"types"}, allEntries = true)
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}

