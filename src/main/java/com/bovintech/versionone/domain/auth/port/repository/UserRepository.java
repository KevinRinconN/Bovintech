package com.bovintech.versionone.domain.auth.port.repository;


import com.bovintech.versionone.domain.auth.model.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getById(String username);
    Optional<User> getByEmail(String email);
    List<User> getAll();
    User create(User request);
    void deleteById(Long id);
    User update(User request);
}
