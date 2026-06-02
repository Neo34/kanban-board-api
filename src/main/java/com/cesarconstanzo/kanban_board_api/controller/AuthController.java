package com.cesarconstanzo.kanban_board_api.controller;

import com.cesarconstanzo.kanban_board_api.dto.LoginRequest;
import com.cesarconstanzo.kanban_board_api.security.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody LoginRequest request
    ) {

        // fake validation
        if (!request.getUsername().equals("admin") ||
                !request.getPassword().equals("123456")) {

            throw new RuntimeException("Invalid credentials");
        }

        String token =
                jwtService.generateToken(request.getUsername());

        return Map.of("token", token);
    }
}