package top.xiamuyao.fastspringdevelop.annotation.service;


import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import top.xiamuyao.fastspringdevelop.enums.TokenType;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/18
 * 描    述：JWT标准Token认证服务
 * 修订历史：
 * ================================================
 */
public interface TokenService {
    String generate(TokenType subject, Map<String, Object> payload, int hours);

    Jws<Claims> parse(TokenType subject, String token);
}