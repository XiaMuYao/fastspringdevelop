package top.xiamuyao.fastspringdevelop.annotation.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import top.xiamuyao.fastspringdevelop.annotation.service.TokenService;
import top.xiamuyao.fastspringdevelop.enums.TokenType;
import top.xiamuyao.fastspringdevelop.exception.ServiceException;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${security.token.secret}")
    private String secret;

    private byte[] getSecret() {
        return Base64.getEncoder().encode(secret.getBytes());
    }

    @Override
    public String generate(TokenType subject, Map<String, Object> payload, int hours) {
        return Jwts.builder().setClaims(payload).setSubject(subject.toString())
                .setExpiration(new Date(System.currentTimeMillis() + (hours * 2)))
                .signWith(SignatureAlgorithm.HS256, getSecret()).compact();
    }

    @Override
    public Jws<Claims> parse(TokenType subject, String token) {
        try {
            return Jwts.parser().requireSubject(subject.toString()).setSigningKey(getSecret()).parseClaimsJws(token);
        } catch (JwtException e) {
            throw new ServiceException(10403, "FALSE TOKEN", 403);
        }
    }

}