package top.xiamuyao.fastspringdevelop.annotation.service;


import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import top.xiamuyao.fastspringdevelop.enums.TokenType;

/**
 * JWT标准Token认证服务
 *
 * @author Li Jinhui
 * @since 2018/12/7
 */
public interface TokenService {
    String generate(TokenType subject, Map<String, Object> payload, int hours);

    Jws<Claims> parse(TokenType subject, String token);
}