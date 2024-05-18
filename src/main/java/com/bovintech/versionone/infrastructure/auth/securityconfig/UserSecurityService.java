package com.bovintech.versionone.infrastructure.auth.securityconfig;

import com.bovintech.versionone.infrastructure.auth.adapter.jpa.repository.UserRepositoryImp;
import com.bovintech.versionone.infrastructure.auth.adapter.mapper.UserDboMapper;
import com.bovintech.versionone.infrastructure.auth.adapter.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepositoryImp userRepository;
    private final UserDboMapper userDboMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDboMapper.toDbo(this.userRepository.getById(username)
                .or(() -> this.userRepository.getByEmail(username))
                .orElseThrow(() -> new UsernameNotFoundException("User with username or email " + username + " not found")));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(String.valueOf(userEntity.getRol()))
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }
}
