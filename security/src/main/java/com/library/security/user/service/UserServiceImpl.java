package com.library.security.user.service;

import com.library.security.user.entity.User;
import com.library.security.user.entity.UserRole;
import com.library.security.user.exceptions.UserFoundException;
import com.library.security.user.repository.RoleRepository;
import com.library.security.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
         User localUser = userRepository.findByUsername(user.getEmail());
         if(localUser!=null){
             System.out.println("User already exist");
             throw new UserFoundException("User already present");
         }
         else {
             for (UserRole userRole:userRoles){
                 roleRepository.save(userRole.getRole());
         }
             user.getUserRoles().addAll(userRoles);
             localUser=userRepository.save(user);
         }
        return localUser;
    }

    @Override
    public User getUserUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public User getUserEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
