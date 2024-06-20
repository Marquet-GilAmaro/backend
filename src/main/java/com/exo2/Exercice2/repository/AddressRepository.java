package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Page<Address> findAddressByVille(String ville, Pageable pageable);
}
