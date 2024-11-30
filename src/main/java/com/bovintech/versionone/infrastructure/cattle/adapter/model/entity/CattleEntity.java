package com.bovintech.versionone.infrastructure.cattle.adapter.model.entity;

import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import com.bovintech.versionone.infrastructure.record.adapter.model.RecordEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "cattle")
public class CattleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
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

    @OneToMany(mappedBy = "dam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CattleEntity> offspringDam;

    @OneToMany(mappedBy = "cattle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordEntity> records;

    @ManyToMany(mappedBy = "cattle")
    private List<EventEntity> events;

    @OneToMany(mappedBy = "dam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BirthEntity> births;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    private CattleLotEntity lot;

}
