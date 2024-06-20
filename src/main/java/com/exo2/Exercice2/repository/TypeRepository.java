package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findTypeByTitle(String title);
}
