package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.AddressDto;
import com.exo2.Exercice2.mapper.AddressMapper;
import com.exo2.Exercice2.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    public List<AddressDto> findAll(Pageable pageable)
    {
        return addressRepository.findAll(pageable).map(addressMapper::toDto).getContent();
    }

    public AddressDto findById(Long id)
    {
        return addressMapper.toDto(addressRepository.findById(id).get());
    }

    public List<AddressDto> findByVille(String ville, Pageable pageable) {
        return addressRepository.findAddressByVille(ville, pageable).map(addressMapper::toDto).getContent();
    }
}
