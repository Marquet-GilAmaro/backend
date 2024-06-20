package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.composite.UserPartyComposite;
import com.exo2.Exercice2.entity.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredRepository extends JpaRepository<Registered, UserPartyComposite> {
}
