package com.confluence.fast.filter

import org.springframework.util.AntPathMatcher
import org.springframework.util.PathMatcher
import org.springframework.web.filter.OncePerRequestFilter
import com.confluence.fast.enums.ResultCode
import com.confluence.fast.util.JwtUtil
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/9/25
 * 描    述：token过滤
 * 修订历史：
 * ================================================
 */
@WebFilter(filterName = "JwtAuthenticationFilter", urlPatterns = ["/api/*"])
class JwtAuthenticationFilter : OncePerRequestFilter() {
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        var request: HttpServletRequest? = request
        try {
            if (isProtectedUrl(request)) {
                request = JwtUtil.validateTokenAndAddUserIdToHeader(request)
            }
        } catch (e: Exception) {
            response.sendError(ResultCode.TOKEN_FALSE.code, e.message)
            return
        }
        filterChain.doFilter(request, response)
    }

    private fun isProtectedUrl(request: HttpServletRequest?): Boolean {
        return pathMatcher.match("/api/**", request!!.servletPath)
    }

    companion object {
        private val pathMatcher: PathMatcher = AntPathMatcher()
    }
}