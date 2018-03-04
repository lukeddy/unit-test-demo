package com.example.ut.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private String address;

    private Role role;

    public enum Role {
        ADMIN, USER;
    }
}
