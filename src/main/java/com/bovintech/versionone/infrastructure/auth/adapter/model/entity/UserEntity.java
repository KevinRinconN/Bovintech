package com.bovintech.versionone.infrastructure.auth.adapter.model.entity;

import com.bovintech.versionone.domain.auth.model.constant.Rol;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleEntity;
import com.bovintech.versionone.infrastructure.cattle.adapter.model.entity.CattleLotEntity;
import com.bovintech.versionone.infrastructure.event.adapter.model.EventEntity;
import com.bovintech.versionone.infrastructure.log.adapter.model.LogEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEntity {
    @Id
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 20)
    private String firstName;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, length = 200)
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, columnDefinition = "TINYINT")
    @ColumnDefault("0")
    @Builder.Default
    private Boolean locked = false;
    @Column(nullable = false, columnDefinition = "TINYINT")
    @ColumnDefault("0")
    @Builder.Default
    private Boolean disabled= false;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CattleLotEntity> ownedLots;

    @OneToMany(mappedBy = "operator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CattleLotEntity> operatedLots;

    @ManyToOne()
    @JoinColumn(name = "owner_id", nullable = true)
    private UserEntity owner;

    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> operators;

    @ManyToMany(mappedBy = "operators")
    private List<EventEntity> eventsToOperator;

    @OneToMany(mappedBy = "owner")
    private List<EventEntity> events;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LogEntity> logs;

}
