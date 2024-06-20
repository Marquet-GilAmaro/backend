package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartyRepository extends JpaRepository<Party, Long> {
    Optional<Party> findPartyByName(String name);
}
