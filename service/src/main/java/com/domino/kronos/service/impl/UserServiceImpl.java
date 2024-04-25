package com.domino.kronos.service.impl;

import com.domino.kronos.domain.User;
import com.domino.kronos.repository.UserRepository;
import com.domino.kronos.service.UserService;
import com.domino.kronos.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return userRepository
                .findById(user.getId())
                .map(usr -> UserMapper.toUser(user, usr))
                .flatMap(userRepository::save);
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userRepository
                .findById(id)
                .flatMap(userRepository::delete);
    }

    @Override
    public Flux<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUser(String id) {
        return userRepository.findById(id);
    }
}
