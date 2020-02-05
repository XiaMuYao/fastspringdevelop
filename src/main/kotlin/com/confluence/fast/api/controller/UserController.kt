package com.confluence.fast.api.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.confluence.fast.api.entity.User
import com.confluence.fast.api.service.IUserService
import com.confluence.fast.util.ResultUtil
import com.confluence.fast.util.RetResult
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
class UserController {

    @Autowired
    private lateinit var iUserService: IUserService

    @GetMapping("demo")
    fun demo(): Any? {
        return iUserService.list()
    }

    @GetMapping("one")
    fun selectUser(): RetResult<User?>? {
        val queryWrapper = QueryWrapper<User>().apply { this.eq("name", "夏沐尧") }
        val one = iUserService.getOne(queryWrapper)
        return ResultUtil.makeOkDataRsp(one)
    }

    @GetMapping("page")
    fun selectUserPage(): RetResult<Page<User>?>? {
        val page = iUserService.page(Page<User>(1, 20))
        return ResultUtil.makeOkDataPageRsp(page)
    }

}