package top.xiamuyao.fastspringdevelop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import top.xiamuyao.fastspringdevelop.enums.ResultCode;
import top.xiamuyao.fastspringdevelop.exception.ServiceException;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/18
 * 描    述：Jwt工具类
 * 修订历史：
 * ================================================
 */
// TODO: 2018/12/19 这里的部分常量弄去yml文件里面
public class JwtUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    /**
     * token时间 1000 hour
     */
    public static final long EXPIRATION_TIME = 86400000;
    /**
     * 生成的密钥
     */
    public static final String SECRET = "ThisIsASecrThisIsASecrThisIsASecrThisIsASecrThisIsASecrThisIThisIsASecrThisIsASecrsASecr";
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * token 在请求头里的key
     */
    public static final String HEADER_STRING = "Authorization";
    public static final String USER_NAME = "userName";

    /**
     * 获得token
     *
     * @param userId
     * @return
     */
    public static String generateToken(String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(USER_NAME, userId);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return TOKEN_PREFIX + jwt;
    }

    /**
     * 自定义解析之后的token请求头
     *
     * @param request
     * @return
     */
    public static HttpServletRequest validateTokenAndAddUserIdToHeader(HttpServletRequest request) throws ServiceException {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            try {
                Map<String, Object> body = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();
                return new CustomHttpServletRequest(request, body);
            } catch (Exception e) {
                logger.info(e.getMessage());
                throw new ServiceException(e.getMessage());
            }
        } else {
            throw new ServiceException("Token解析或获取失败", ResultCode.TOKEN_FALSE);
        }
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Map<String, Object> parse(String token) {
        try {
            // parse the token.
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            return body;
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Token. " + e.getMessage());
        }
    }

    public static class CustomHttpServletRequest extends HttpServletRequestWrapper {
        private Map<String, String> claims;

        CustomHttpServletRequest(HttpServletRequest request, Map<String, ?> claims) {
            super(request);
            this.claims = new HashMap<>();
            claims.forEach((k, v) -> this.claims.put(k, String.valueOf(v)));
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            if (claims != null && claims.containsKey(name)) {
                return Collections.enumeration(Arrays.asList(claims.get(name)));
            }
            return super.getHeaders(name);
        }

        public Map<String, String> getClaims() {
            return claims;
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(generateToken("xiamuyao"));
        System.out.println(System.currentTimeMillis());
    }

}