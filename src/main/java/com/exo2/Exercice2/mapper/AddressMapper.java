package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.AddressDto;
import com.exo2.Exercice2.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressDto addressDto);
    List<AddressDto> toDtos(List<Address> addresses);
    List<Address> toEntities(List<AddressDto> addressesDto);
}
