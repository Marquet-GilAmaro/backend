package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Interest;
import com.exo2.Exercice2.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    Optional<Interest> findInterestByTitle(String title);
}
