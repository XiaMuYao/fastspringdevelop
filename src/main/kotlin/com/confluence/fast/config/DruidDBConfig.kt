package com.confluence.fast.config

import com.alibaba.druid.support.http.StatViewServlet
import com.alibaba.druid.support.http.WebStatFilter
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/9/25
 * 描    述：
 * 修订历史：
 * ================================================
 */
@Configuration
@Slf4j
class DruidDBConfig {
    /**
     * 注册一个StatViewServlet
     *
     * @return
     */
    @Bean
    fun DruidStatViewServle(): ServletRegistrationBean<*> { //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        val servletRegistrationBean: ServletRegistrationBean<*> = ServletRegistrationBean(StatViewServlet(), "/druid/*")
        //添加初始化参数：initParams
//白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1")
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        servletRegistrationBean.addInitParameter("deny", "192.168.0.114")
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin")
        servletRegistrationBean.addInitParameter("loginPassword", "123456")
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false")
        return servletRegistrationBean
    }

    /**
     * 注册一个：filterRegistrationBean
     *
     * @return
     */
    @Bean
    fun druidStatFilter(): FilterRegistrationBean<*> {
        val filterRegistrationBean: FilterRegistrationBean<*> = FilterRegistrationBean(WebStatFilter())
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*")
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
        return filterRegistrationBean
    }
}