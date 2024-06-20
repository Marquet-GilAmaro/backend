package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.TypeDto;
import com.exo2.Exercice2.entity.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = ProjetMapper.class)
public interface TypeMapper {
    // Single Object
    Type toEntity(TypeDto typeDto);
    @Mapping(target = "projets.types", ignore = true)
    TypeDto toDto(Type typeDto);
    // List of Objects
    List<Type> toEntities(List<TypeDto> typeDtos);

    List<TypeDto> toDtos(List<Type> types);

}
