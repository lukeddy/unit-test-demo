package com.example.ut.demo.repository;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ut.demo.domain.User;
import com.example.ut.demo.domain.User.Role;

@Component
public class UserRepository {

    private static final User USER1 = new User(1L, "YongQiang", "ShangHai", Role.ADMIN);
    private static final User USER2 = new User(2L, "ChangGui", "ShangHai", Role.USER);

    private static final Map<Long, User> USERS = Arrays.asList(USER1, USER2).stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));

    public User findById(Long id) {
        return USERS.get(id);
    }
}
