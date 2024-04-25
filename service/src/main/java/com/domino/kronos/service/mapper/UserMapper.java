package com.domino.kronos.service.mapper;

import com.domino.kronos.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User toUser(User src, User dest) {
        return dest
                .toBuilder()
                .id(src.getId())
                .firstName(src.getFirstName())
                .lastName(src.getLastName())
                .email(src.getEmail())
                .build();
    }
}
