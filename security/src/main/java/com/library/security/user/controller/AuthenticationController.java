package com.library.security.user.controller;

import com.library.security.user.config.JwtUtils;
import com.library.security.user.entity.User;
import com.library.security.user.exceptions.UserNotFoundException;
import com.library.security.user.model.JwtRequest;
import com.library.security.user.model.JwtResponse;
import com.library.security.user.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found");
        }

        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token=this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException disabledException){
            throw  new Exception("User disabled "+disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Invalid credentials "+ badCredentialsException.getMessage());
        }
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }

}
