package com.test.demo.service;

import com.test.demo.dto.LoginRequest;
import com.test.demo.model.User;
import com.test.demo.repository.UserRepository;
import com.test.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User.not.found"));
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid.credentials");
    }
}
