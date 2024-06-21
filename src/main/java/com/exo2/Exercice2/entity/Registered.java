package com.exo2.Exercice2.entity;

import com.exo2.Exercice2.composite.UserPartyComposite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "registered",
        indexes = {
                @Index(name = "idx_registered_rating", columnList = "rating")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registered {

    @EmbeddedId
    private UserPartyComposite id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("partyId")
    @JoinColumn(name = "party_id")
    private Party party;

    @Column(name = "is_organizer", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isOrganizer;

    @Column(name = "rating") // Only for isOrganizer = false
    private int rating;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
}
