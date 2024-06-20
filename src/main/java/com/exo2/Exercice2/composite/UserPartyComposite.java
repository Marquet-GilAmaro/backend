package com.exo2.Exercice2.composite;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPartyComposite implements Serializable {
    private Long userId;
    private Long partyId;
}
