package com.confluence.fast

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("com.confluence.fast.api.mapper")
class FastApplication

fun main(args: Array<String>) {
    runApplication<FastApplication>(*args)
}
