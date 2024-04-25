package com.domino.kronos.service;

import com.domino.kronos.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> createUser(User user);

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(String id);

    Flux<User> allUsers();

    Mono<User> getUser(String id);
}
