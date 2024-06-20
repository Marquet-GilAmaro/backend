package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.EtudiantDto;
import com.exo2.Exercice2.dto.PartyDto;
import com.exo2.Exercice2.entity.Etudiant;
import com.exo2.Exercice2.entity.Party;
import com.exo2.Exercice2.mapper.PartyMapper;
import com.exo2.Exercice2.repository.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PartyService {
    private PartyRepository partyRepository;
    private PartyMapper partyMapper;

    @Cacheable(value = "partys", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public List<PartyDto> findAll(Pageable pageable) {
        return partyRepository.findAll(pageable).map(partyMapper::toDto).getContent();
    }

    @Cacheable(value = "partys", key = "#id")
    public PartyDto findById(long id) {
        return partyMapper.toDto(partyRepository.findById(id).orElse(null));
    }

    @Cacheable(value = "partys", key = "#name")
    public PartyDto findOneByName(String name) {
        return partyMapper.toDto(partyRepository.findPartyByName(name).orElse(null));
    }

    @CacheEvict(value = "partys", allEntries = true)
    public PartyDto save(PartyDto partyDto) {
        return partyMapper.toDto(partyRepository.save(partyMapper.toEntity(partyDto)));
    }

   public PartyDto update(Long id, PartyDto partyDto) {
    return partyRepository.findById(id)
            .map(existingParty -> {
                Party party = partyMapper.toEntity(partyDto);
                party.setId(id);
                if (Objects.nonNull(existingParty.getDate())) {
                    party.setDate(existingParty.getDate());
                }
                if (Objects.nonNull(existingParty.getPlaceNb())) {
                    party.setPlaceNb(existingParty.getPlaceNb());
                }
                if(Objects.nonNull(existingParty.getPrice()) || existingParty.getPrice() != 0) {
                    party.setPrice(existingParty.getPrice());
                }
                return partyMapper.toDto(partyRepository.save(party));
            })
            .orElse(null);
}

    @CacheEvict(value = {"party"}, allEntries = true)
    public void delete(Long id) {
        partyRepository.deleteById(id);
    }
}

