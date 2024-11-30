package com.bovintech.versionone.infrastructure.cattle.adapter.model.entity;

import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "lot")
public class CattleLotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id", nullable = true)
    private UserEntity operator;

    @ManyToMany(mappedBy = "lots")
    private List<EventEntity> events;

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CattleEntity> cattle;

}
