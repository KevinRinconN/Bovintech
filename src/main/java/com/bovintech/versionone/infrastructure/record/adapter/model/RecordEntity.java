package com.bovintech.versionone.infrastructure.record.adapter.model;

import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "record")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false)
    private LocalDate dateOfRecord;

    @ManyToOne
    @JoinColumn(name = "cattle_id")
    private CattleEntity cattle;
}
