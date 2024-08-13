package com.bovintech.versionone.infrastructure.cattle.adapter.model.entity;

import com.bovintech.versionone.domain.cattle.model.dto.Cattle;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "cattle")
public class CattleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "distinctive_trait")
    private String distinctiveTrait;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String breed;
    private String brand;

    @ManyToOne
    @JoinColumn(name = "sire_id")
    private CattleEntity sire; // padre

    @ManyToOne
    @JoinColumn(name = "dam_id")
    private CattleEntity dam; // madre

    @OneToMany(mappedBy = "sire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CattleEntity> offspring;

}
