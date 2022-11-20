package com.library.security.user.service;

import com.library.security.user.entity.User;
import com.library.security.user.entity.UserRole;

import java.util.Set;

public interface UserService {
    User saveUser(User user, Set <UserRole> userRoles) throws Exception;

    User getUserUsername(String username);

    User getUserEmail(String username);

    void deleteUser(Long userId);
}
