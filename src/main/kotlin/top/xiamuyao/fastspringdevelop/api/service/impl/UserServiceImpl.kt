package top.xiamuyao.fastspringdevelop.api.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.xiamuyao.fastspringdevelop.api.entity.User
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper
import top.xiamuyao.fastspringdevelop.api.service.IUserService

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
class UserServiceImpl : ServiceImpl<UserMapper?, User?>(), IUserService