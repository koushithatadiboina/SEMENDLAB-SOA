package com.bank.logicom.example.jwtgeneration;


import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/generate")
    public Map<String, String> generateToken(
            @RequestBody Map<String, Object> payload) {

        String token = jwtService.generateToken(payload);

        return Map.of("token", token);
    }
}

