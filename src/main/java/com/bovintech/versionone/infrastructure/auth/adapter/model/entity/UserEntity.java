package com.bovintech.versionone.infrastructure.auth.adapter.model.entity;

import com.bovintech.versionone.domain.auth.model.constant.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
}
