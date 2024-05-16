package com.bovintech.versionone.infrastructure.auth.adapter.jpa.repository;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import com.bovintech.versionone.infrastructure.auth.adapter.jpa.UserJpaRepository;
import com.bovintech.versionone.infrastructure.auth.adapter.mapper.UserDboMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImp implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserDboMapper userDboMapper;

    @Override
    public Optional<User> getById(String username) {
        var optionalUser = userJpaRepository.findById(username);

        return optionalUser.map(userDboMapper::toDomain);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        var optionalUser = userJpaRepository.findByEmail(email);

        return optionalUser.map(userDboMapper::toDomain);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User create(User request) {
        var userToSave = userDboMapper.toDbo(request);
        var userSaved = userJpaRepository.save(userToSave);
        return userDboMapper.toDomain(userSaved);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User update(User request) {
        return null;
    }
}
