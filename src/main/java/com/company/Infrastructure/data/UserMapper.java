package com.company.Infrastructure.data;

public interface UserMapper {

    User findByEmail(String email);
    User findByUsername(String userName);
}
