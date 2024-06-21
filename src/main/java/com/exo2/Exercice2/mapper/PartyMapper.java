package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.PartyDto;
import com.exo2.Exercice2.entity.Party;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = PartyMapper.class)
public interface PartyMapper {
    // Single Object
    Party toEntity(PartyDto partyDto);
    @Mapping(target = "projets.partys", ignore = true)
    PartyDto toDto(Party partyDto);
    // List of Objects
    List<Party> toEntities(List<PartyDto> partyDtos);

    List<PartyDto> toDtos(List<Party> partys);

}
