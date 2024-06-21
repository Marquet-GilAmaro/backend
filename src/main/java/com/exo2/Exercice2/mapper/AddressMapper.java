package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.AddressDto;
import com.exo2.Exercice2.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = AddressMapper.class)
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressDto addressDto);
    List<AddressDto> toDtos(List<Address> addresses);
    List<Address> toEntities(List<AddressDto> addressesDto);
}
