package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.InterestDto;
import com.exo2.Exercice2.entity.Interest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = InterestMapper.class)
public interface InterestMapper {
    // Single Object
    Interest toEntity(InterestDto interestDto);
    @Mapping(target = "projets.interests", ignore = true)
    InterestDto toDto(Interest interestDto);
    // List of Objects
    List<Interest> toEntities(List<InterestDto> interestDtos);

    List<InterestDto> toDtos(List<Interest> interests);

}
