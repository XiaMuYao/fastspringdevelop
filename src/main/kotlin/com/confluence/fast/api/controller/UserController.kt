package com.confluence.fast.api.controller

import com.confluence.fast.api.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 *
 * 用户表 前端控制器
 *
 *
 * @author XiaMuYao
 * @since 2020-02-06
 */
@RestController
@RequestMapping("/api/user")
class UserController{


    @Autowired
    private lateinit var iUserService: IUserService

    @GetMapping("demo")
    fun demo(): Any? {
        return iUserService.list()
    }

}