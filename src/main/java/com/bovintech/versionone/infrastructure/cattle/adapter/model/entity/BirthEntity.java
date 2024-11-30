package com.bovintech.versionone.infrastructure.cattle.adapter.model.entity;

import com.bovintech.versionone.domain.cattle.model.constant.BirthStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "births")
public class BirthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;  // Fecha del parto

    @Temporal(TemporalType.DATE)
    @Column(name = "insemination_date", nullable = false)
    private LocalDate inseminationDate;  // Fecha de inseminación

    @ManyToOne
    @JoinColumn(name = "dam_id", nullable = false)
    private CattleEntity dam; // Madre que dio a luz

    @ManyToOne
    @JoinColumn(name = "sire_id", nullable = false)
    private CattleEntity sire; // Padre que engendró al ternero

    @ManyToOne
    @JoinColumn(name = "calf_id")
    private CattleEntity calf; // Ternero nacido

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BirthStatus status = BirthStatus.EN_PROCESO;

    @Column(name = "is_abortion", nullable = false)
    private boolean isAbortion = true;  // Indica si el parto fue un aborto

    @Column(name = "abortion_reason")
    private String abortionReason;  // Razón del aborto (opcional)
}
