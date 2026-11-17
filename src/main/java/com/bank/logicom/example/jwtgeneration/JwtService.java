package com.bank.logicom.example.jwtgeneration;


import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JwtService {

    private final SecretKey secretKey;

    public JwtService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(Map<String, Object> claims) {

        long currentTime = System.currentTimeMillis();

        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date(currentTime))
                .expiration(new Date(currentTime + 3600000))
                .signWith(secretKey)
                .compact();
    }
}
