package com.dans.test.service;

import com.dans.test.dto.ChangePasswordRequest;
import com.dans.test.dto.LoginRequest;
import com.dans.test.model.User;
import com.dans.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
 @Autowired
 PasswordEncoder passwordEncoder;

 @Autowired
 UserRepository repository;


    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }
    
    public String login(LoginRequest request) {
        Optional<User> byEmail = repository.findByEmail(request.getUsername());
        if (byEmail.isEmpty()) {
            return "Invalid username or password";
        }

        String passEncode = passwordEncoder.matches(request.getPassword(), byEmail.get().getPassword()) ? byEmail.get().getPassword() : null;
        if (Objects.equals(passEncode, byEmail.get().getPassword())) {
            return "Login Success";
        } else {
            return "Invalid username or password";
        }
    }
}
