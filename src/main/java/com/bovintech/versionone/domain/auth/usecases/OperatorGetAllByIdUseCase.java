package com.bovintech.versionone.domain.auth.usecases;

import com.bovintech.versionone.domain.auth.model.dto.User;
import com.bovintech.versionone.domain.auth.model.exception.UserNotFoundException;
import com.bovintech.versionone.domain.auth.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OperatorGetAllByIdUseCase {
    private final UserRepository userRepository;

    public List<User> execute (List<String> usernames){
        List<User> operators = userRepository.findAllById(usernames);
        if(operators.size() != usernames.size()){
            throw new UserNotFoundException();
        }
        return operators;
    }
}
