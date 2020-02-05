package com.confluence.fast.util

import org.slf4j.LoggerFactory
import com.confluence.fast.enums.ResultCode
import com.confluence.fast.exception.ServiceException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/18
 * 描    述：Jwt工具类
 * 修订历史：
 * ================================================
 */
object JwtUtil {
    private val logger = LoggerFactory.getLogger(JwtUtil::class.java)
    /**
     * token时间 1000 hour
     */
    const val EXPIRATION_TIME: Long = 86400000
    /**
     * 生成的密钥
     */
    const val SECRET = "ThisIsASecrThisIsASecrThisIsASecrThisIsASecrThisIsASecrThisIThisIsASecrThisIsASecrsASecr"
    const val TOKEN_PREFIX = "Bearer "
    /**
     * token 在请求头里的key
     */
    const val HEADER_STRING = "Authorization"
    const val USER_NAME = "userName"
    /**
     * 获得token
     *
     * @param userId
     * @return
     */
    fun generateToken(userId: String): String {
        val map = HashMap<String, Any>()
        map[USER_NAME] = userId
        val jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact()
        return TOKEN_PREFIX + jwt
    }

    /**
     * 自定义解析之后的token请求头
     *
     * @param request
     * @return
     */
    @Throws(ServiceException::class)
    fun validateTokenAndAddUserIdToHeader(request: HttpServletRequest?): HttpServletRequest {
        val token = request!!.getHeader(HEADER_STRING)
        return if (token != null) {
            try {
                val body: Map<String?, Any> = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .body
                CustomHttpServletRequest(request, body)
            } catch (e: Exception) {
                logger.info(e.message)
                throw ServiceException(e.message)
            }
        } else {
            throw ServiceException("Token解析或获取失败", ResultCode.TOKEN_FALSE)
        }
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    fun parse(token: String): Map<String, Any> {
        return try { // parse the token.
            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .body
        } catch (e: Exception) {
            throw IllegalStateException("Invalid Token. " + e.message)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(System.currentTimeMillis())
        println(generateToken("xiamuyao"))
        println(System.currentTimeMillis())
    }

    class CustomHttpServletRequest internal constructor(request: HttpServletRequest?, claims: Map<String?, Any>) : HttpServletRequestWrapper(request) {
        private val claims: MutableMap<String?, String>?
        override fun getHeaders(name: String): Enumeration<String> {
            return if (claims != null && claims.containsKey(name)) {
                Collections.enumeration(listOf(claims[name]))
            } else super.getHeaders(name)
        }

        fun getClaims(): Map<String?, String>? {
            return claims
        }

        init {
            this.claims = HashMap()
            claims.forEach { (k: String?, v: Any) -> this.claims[k] = v.toString() }
        }
    }
}