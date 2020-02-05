package com.confluence.fast.api.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.confluence.fast.api.entity.User
import com.confluence.fast.api.mapper.UserMapper
import org.springframework.stereotype.Service
import com.confluence.fast.api.service.IUserService as IUserService1


/**
 *
 *
 * 用户表 服务实现类
 *
 *
 * @author XiaMuYao
 * @since 2020-02-06
 */
@Service
class UserServiceImpl : ServiceImpl<UserMapper, User>(), IUserService1