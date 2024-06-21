package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.RegisteredDto;
import com.exo2.Exercice2.entity.Registered;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = RegisteredMapper.class)
public interface RegisteredMapper {
    RegisteredDto toDto(Registered registered);

    Registered toEntity(RegisteredDto registeredDto);

    List<RegisteredDto> toDtos(List<Registered> registereds);

    List<Registered> toEntities(List<RegisteredDto> registeredsDto);
}
