package com.confluence.fast.config

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.confluence.fast.api.mapper*")
internal class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    fun paginationInterceptor(): PaginationInterceptor {
        return PaginationInterceptor()
    }
}