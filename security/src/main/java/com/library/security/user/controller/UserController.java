package com.library.security.user.controller;

import com.library.security.user.entity.Role;
import com.library.security.user.entity.User;
import com.library.security.user.entity.UserRole;
import com.library.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/library/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    @PostMapping("/registerUser")
    public User register(@RequestBody User user) throws Exception{

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        Set<UserRole> userRoles=new HashSet<>();

        Role role =new Role();
        role.setId(2L);
        role.setName("ADMIN");

        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoles.add(userRole);

        return userService.saveUser(user,userRoles);
    }

    @GetMapping("/getUser/username/{username}")
    public User getUserUsername(@PathVariable("username") String username){
        return userService.getUserUsername(username);
    }

    @GetMapping("/getUser/email/{email}")
    public User getUserEmail(@PathVariable("email") String email){
        return userService.getUserEmail(email);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}
